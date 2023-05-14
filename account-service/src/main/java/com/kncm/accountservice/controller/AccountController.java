package com.kncm.accountservice.controller;

import com.kncm.accountservice.dto.JwtAuthenticationRequest;
import com.kncm.accountservice.dto.UserDetailsRequest;
import com.kncm.accountservice.dto.UserTokenState;
import com.kncm.accountservice.handler.exceptions.UserDetailsRequestIsNotValidException;
import com.kncm.accountservice.handler.exceptions.UserWithPassedIdDoesNotExistException;
import com.kncm.accountservice.handler.exceptions.UsernameIsNotUniqueException;
import com.kncm.accountservice.model.Address;
import com.kncm.accountservice.model.User;
import com.kncm.accountservice.security.util.TokenGenerator;
import com.kncm.accountservice.service.RoleService;
import com.kncm.accountservice.service.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import proto.Accommodation;
import proto.UserServiceGrpc;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang.StringUtils.isBlank;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {
    private final UserService service;
    private final RoleService roleService;
    private AuthenticationManager authenticationManager;
    private TokenGenerator tokenGenerator;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserDetailsRequest dto) {
        if (isUserDetailsRequestValid(dto)) {
            User user = new User();
            Map(dto, user);
            boolean responseStatus = false;

            if (!service.exists(user.getUsername())) {
                // Create a gRPC channel to the accommodation-service
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                        .usePlaintext()
                        .build();

                // Create a gRPC client stub for the accommodation-service
                UserServiceGrpc.UserServiceBlockingStub userServiceStub = UserServiceGrpc.newBlockingStub(channel);
                try {
                    // Create a gRPC request to create a user in the accommodation-service
                    Accommodation.CreateUserRequest accommodationRequest = Accommodation.CreateUserRequest.newBuilder()
                            .setUsername(dto.getUsername())
                            .setPassword(dto.getPassword())
                            .setName(dto.getName())
                            .setSurname(dto.getSurname())
                            .setRole(dto.getRoleName())
                            .build();

                    // Make the gRPC request to create the user in the accommodation-service
                    Accommodation.CreateUserResponse accommodationResponse = userServiceStub.createUser(accommodationRequest);
                    if (accommodationResponse.getIsCreated()) {
                        responseStatus = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Grpc exception happened");
                } finally {
                    // Shutdown the gRPC channel
                    channel.shutdown();
                    try {
                        channel.awaitTermination(5, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        // Handle channel shutdown interruption
                        System.out.println("Shutdown interruption happened");
                    }
                }
            } else {
                throw new UsernameIsNotUniqueException();
            }

            if (responseStatus) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                service.save(user);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            throw new UserDetailsRequestIsNotValidException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UserDetailsRequest dto) {
        if (isUserDetailsRequestValid(dto)) {
            User user = service.find(id);
            if (user != null) {
                if (dto.getUsername().equals(user.getUsername())) {
                    if (dto.getPassword().equals(user.getPassword())) {
                        Map(dto, user);
                        service.save(user);
                    } else {
                        Map(dto, user);
                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                        service.save(user);
                    }
                } else {
                    Map(dto, user);
                    if (!service.exists(user.getUsername())) {
                        service.save(user);
                    } else {
                        throw new UsernameIsNotUniqueException();
                    }
                }

                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                throw new UserWithPassedIdDoesNotExistException();
            }
        } else {
            throw new UserDetailsRequestIsNotValidException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        User user = service.find(id);
        if (user != null) {
            //if (grpc calls) {
            service.delete(user);
            return new ResponseEntity<>(HttpStatus.OK);
            //} else {
            //      throw ../
            // }
        } else {
            throw new UserWithPassedIdDoesNotExistException();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenGenerator.generate(authenticationRequest.getUsername());
        int expiresIn = tokenGenerator.getExpiredIn();

        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }


    private void Map(UserDetailsRequest dto, User user) {
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        user.setAddress(address);
        user.setRole(roleService.find(dto.getRoleName()));

    }

    private boolean isUserDetailsRequestValid(UserDetailsRequest dto) {
        return !isBlank(dto.getUsername()) && !isBlank(dto.getPassword())
                && !isBlank(dto.getName()) && !isBlank(dto.getSurname())
                && !isBlank(dto.getEmail()) && !isBlank(dto.getCountry())
                && !isBlank(dto.getCity()) && !isBlank(dto.getStreet())
                && !isBlank(dto.getNumber()) && !isBlank(dto.getRoleName());
    }
}
