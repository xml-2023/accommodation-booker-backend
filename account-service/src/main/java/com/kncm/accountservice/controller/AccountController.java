package com.kncm.accountservice.controller;

import com.kncm.accountservice.dto.JwtAuthenticationRequest;
import com.kncm.accountservice.dto.UserDetailsRequest;
import com.kncm.accountservice.dto.UserTokenState;
import com.kncm.accountservice.handler.exceptions.UserDetailsRequestIsNotValidException;
import com.kncm.accountservice.handler.exceptions.UserHaveActiveReservationsException;
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
import proto.*;

import java.util.ArrayList;
import java.util.List;
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

    @PostMapping("/host")
    public ResponseEntity<Void> createHost(@RequestBody UserDetailsRequest dto) {
        if (isUserDetailsRequestValid(dto)) {
            User user = new User();
            Map(dto, user);
            boolean responseStatus = false;
            boolean responseStatusRating = false;
            Long userId = 0L;

            if (!service.exists(user.getUsername())) {
                // Create a gRPC channel to the accommodation-service
                //-------------------------------------------Create host in accommodation service----------------------------------------------
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                        .usePlaintext()
                        .build();

                // Create a gRPC client stub for the accommodation-service
                CreateUserServiceGrpc.CreateUserServiceBlockingStub userServiceStub = CreateUserServiceGrpc.newBlockingStub(channel);
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
                        userId = accommodationResponse.getUserId();
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
                //-------------------------------------------Create host in accommodation service end ----------------------------------------------

                //-------------------------------------------Create host in rating service----------------------------------------------
                ManagedChannel ratingChannel = ManagedChannelBuilder.forAddress("localhost", 9099)
                        .usePlaintext()
                        .build();

                try {
                    ManageUserServiceGrpc.ManageUserServiceBlockingStub stub = ManageUserServiceGrpc.newBlockingStub(ratingChannel);

                    AccountRating.CreateUserRequest request = AccountRating.CreateUserRequest.newBuilder()
                            .setUserId(userId)
                            .setUsername(dto.getUsername())
                            .setPassword(dto.getPassword())
                            .setName(dto.getName())
                            .setSurname(dto.getSurname())
                            .setRole(dto.getRoleName())
                            .build();

                    AccountRating.CreateUserResponse response = stub.createUser(request);
                    if (response.getIsCreated()) {
                        responseStatusRating = true;
                        userId = response.getUserId();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Grpc exception happened");
                } finally {
                    // Shutdown the gRPC channel
                    channel.shutdown();
                }
                //-------------------------------------------Create host in rating service end ----------------------------------------------
            } else {
                throw new UsernameIsNotUniqueException();
            }

            if (responseStatus && responseStatusRating) {
                user.setId(userId);
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


    @PostMapping("/guest")
    public ResponseEntity<Void> createGuest(@RequestBody UserDetailsRequest dto) {
        if (isUserDetailsRequestValid(dto)) {
            User user = new User();
            Map(dto, user);
            Long userId = Long.valueOf(System.currentTimeMillis());
            if (!service.exists(user.getUsername())) {
                user.setId(userId);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                service.save(user);

                //-------------------------------------------Create host in reservation service----------------------------------------------
                // Create a gRPC channel to the accommodation-service
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9094)
                        .usePlaintext()
                        .build();

                // Create a gRPC client stub for the accommodation-service
                CreateGuestServiceGrpc.CreateGuestServiceBlockingStub guestServiceStub = CreateGuestServiceGrpc.newBlockingStub(channel);
                try {
                    // Create a gRPC request to create a user in the accommodation-service
                    AccountReservation.CreateGuestRequest reservationRequest = AccountReservation.CreateGuestRequest.newBuilder()
                            .setUserId(userId)
                            .setUsername(dto.getUsername())
                            .setPassword(dto.getPassword())
                            .setName(dto.getName())
                            .setSurname(dto.getSurname())
                            .setRole(dto.getRoleName())
                            .build();

                    // Make the gRPC request to create the user in the accommodation-service
                    AccountReservation.CreateGuestResponse guestResponse = guestServiceStub.createUser(reservationRequest);
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
                //-------------------------------------------Create host in reservation service end----------------------------------------------
                //-------------------------------------------Create host in rating service----------------------------------------------
                ManagedChannel ratingChannel = ManagedChannelBuilder.forAddress("localhost", 9099)
                        .usePlaintext()
                        .build();

                // Create a gRPC client stub for the accommodation-service
                ManageUserServiceGrpc.ManageUserServiceBlockingStub stub = ManageUserServiceGrpc.newBlockingStub(ratingChannel);
                try {
                    // Create a gRPC request to create a user in the accommodation-service
                    AccountRating.CreateUserRequest request = AccountRating.CreateUserRequest.newBuilder()
                            .setUserId(userId)
                            .setUsername(dto.getUsername())
                            .setPassword(dto.getPassword())
                            .setName(dto.getName())
                            .setSurname(dto.getSurname())
                            .setRole(dto.getRoleName())
                            .build();

                    // Make the gRPC request to create the user in the accommodation-service
                    AccountRating.CreateUserResponse response = stub.createUser(request);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Grpc exception happened");
                } finally {
                    // Shutdown the gRPC channel
                    ratingChannel.shutdown();
                }
                //-------------------------------------------Create host in rating service end----------------------------------------------
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                throw new UsernameIsNotUniqueException();
            }


        } else {
            throw new UserDetailsRequestIsNotValidException();
        }
    }

    @PutMapping("/host/{id}")
    public ResponseEntity<Void> updateHost(@PathVariable Long id, @RequestBody UserDetailsRequest dto) {
        if (isUserDetailsRequestValid(dto)) {
            boolean responseStatus = false;
            User user = service.find(id);
            if (user != null) {
                // Create a gRPC channel to the accommodation-service
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                        .usePlaintext()
                        .build();

                // Create a gRPC client stub for the accommodation-service
                CreateUserServiceGrpc.CreateUserServiceBlockingStub userServiceStub = CreateUserServiceGrpc.newBlockingStub(channel);
                try {
                    // Create a gRPC request to update a user in the accommodation-service
                    Accommodation.UpdateUserRequest accommodationRequest = Accommodation.UpdateUserRequest.newBuilder()
                            .setUserId(id)
                            .setUsername(dto.getUsername())
                            .setPassword(dto.getPassword())
                            .setName(dto.getName())
                            .setSurname(dto.getSurname())
                            .setRole(dto.getRoleName())
                            .build();

                    // Make the gRPC request to create the user in the accommodation-service
                    Accommodation.UpdateUserResponse accommodationResponse = userServiceStub.updateUser(accommodationRequest);
                    if (accommodationResponse.getIsUpdated()) {
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

                if (responseStatus) {
                    if (dto.getPassword().equals(user.getPassword())) {
                        Map(dto, user);
                        service.save(user);
                    } else {
                        Map(dto, user);
                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                        service.save(user);
                    }

                    return new ResponseEntity<>(HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                throw new UserWithPassedIdDoesNotExistException();
            }
        } else {
            throw new UserDetailsRequestIsNotValidException();
        }
    }


    @PutMapping("/guest/{id}")
    public ResponseEntity<Void> updateGuest(@PathVariable Long id, @RequestBody UserDetailsRequest dto) {
        if (isUserDetailsRequestValid(dto)) {
            boolean responseStatus = false;
            User user = service.find(id);
            if (user != null) {
                // Create a gRPC channel to the accommodation-service
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9094)
                        .usePlaintext()
                        .build();

                // Create a gRPC client stub for the accommodation-service
                CreateGuestServiceGrpc.CreateGuestServiceBlockingStub guestServiceStub = CreateGuestServiceGrpc.newBlockingStub(channel);
                try {
                    // Create a gRPC request to update a user in the accommodation-service
                    AccountReservation.UpdateGuestRequest guestRequest = AccountReservation.UpdateGuestRequest.newBuilder()
                            .setUserId(id)
                            .setUsername(dto.getUsername())
                            .setPassword(dto.getPassword())
                            .setName(dto.getName())
                            .setSurname(dto.getSurname())
                            .setRole(dto.getRoleName())
                            .build();

                    // Make the gRPC request to create the user in the accommodation-service
                    AccountReservation.UpdateGuestResponse accommodationResponse = guestServiceStub.updateUser(guestRequest);
                    if (accommodationResponse.getIsUpdated()) {
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

                if (responseStatus) {
                    if (dto.getPassword().equals(user.getPassword())) {
                        Map(dto, user);
                        service.save(user);
                    } else {
                        Map(dto, user);
                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                        service.save(user);
                    }

                    return new ResponseEntity<>(HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                throw new UserWithPassedIdDoesNotExistException();
            }
        } else {
            throw new UserDetailsRequestIsNotValidException();
        }
    }



    @DeleteMapping("/guest/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        User user = service.find(id);
        boolean responseStatus = false;
        if (user != null) {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9094)
                    .usePlaintext()
                    .build();

            CreateGuestServiceGrpc.CreateGuestServiceBlockingStub guestServiceStub = CreateGuestServiceGrpc.newBlockingStub(channel);
            try {
                AccountReservation.DeleteGuestRequest guestRequest = AccountReservation.DeleteGuestRequest.newBuilder()
                        .setUserId(id)
                        .build();

                AccountReservation.DeleteGuestResponse guestResponse = guestServiceStub.deleteUser(guestRequest);
                if (guestResponse.getIsDeleted()) {
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

                if (responseStatus) {
                    service.delete(user);
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    throw new UserHaveActiveReservationsException();
                }
            }
        } else {
            throw new UserWithPassedIdDoesNotExistException();
        }
    }


    @DeleteMapping("/host/{id}")
    public ResponseEntity<Void> deleteHost(@PathVariable Long id) {
        User user = service.find(id);
        List<Long> accommodationIds = new ArrayList<>();
        boolean canBeDeleted = false;
        boolean responseStatus = false;
        if (user != null) {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9095)
                    .usePlaintext()
                    .build();

            AccountAccommodationServiceGrpc.AccountAccommodationServiceBlockingStub accountAccommodationServiceStub =  AccountAccommodationServiceGrpc.newBlockingStub(channel);
            try {
                AccountAccommodation.CreateAccountAccommodationRequest accountAccommodationRequest = AccountAccommodation.CreateAccountAccommodationRequest.newBuilder()
                        .setUserId(id)
                        .build();

                AccountAccommodation.CreateAccountAccommodationResponse accountAccommodationResponse = accountAccommodationServiceStub.getAccommodations(accountAccommodationRequest);
                accommodationIds = accountAccommodationResponse.getAccommodationIdsList();
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

                //********************************************************************************

                ManagedChannel channel1 = ManagedChannelBuilder.forAddress("localhost", 9094)
                        .usePlaintext()
                        .build();

                CreateGuestServiceGrpc.CreateGuestServiceBlockingStub guestServiceStub = CreateGuestServiceGrpc.newBlockingStub(channel1);
                try {
                    AccountReservation.CanHostBeDeletedRequest.Builder requestBuilder  =  AccountReservation.CanHostBeDeletedRequest.newBuilder();
                    for (int i = 0; i < accommodationIds.size(); i++) {
                        requestBuilder.addAccommodationIds(accommodationIds.get(i));
                    }
                    AccountReservation.CanHostBeDeletedRequest request = requestBuilder.build();

                    AccountReservation.CanHostBeDeletedResponse response = guestServiceStub.canHostBeDeleted(request);
                    if (response.getCanBeDeleted()) {
                        canBeDeleted = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Grpc exception happened");
                } finally {
                    // Shutdown the gRPC channel
                    channel1.shutdown();
                    try {
                        channel1.awaitTermination(5, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        // Handle channel shutdown interruption
                        System.out.println("Shutdown interruption happened");
                    }
                }

                    //*********************************************************************************

                    if (canBeDeleted) {
                        ManagedChannel channel2 = ManagedChannelBuilder.forAddress("localhost", 9091)
                                .usePlaintext()
                                .build();

                        // Create a gRPC client stub for the accommodation-service
                        CreateUserServiceGrpc.CreateUserServiceBlockingStub userServiceStub = CreateUserServiceGrpc.newBlockingStub(channel2);
                        try {
                            // Create a gRPC request to update a user in the accommodation-service
                            Accommodation.DeleteUserRequest deleteRequest = Accommodation.DeleteUserRequest.newBuilder()
                                    .setUserId(id)
                                    .build();

                            // Make the gRPC request to create the user in the accommodation-service
                            Accommodation.DeleteUserResponse accommodationResponse = userServiceStub.deleteUser(deleteRequest);
                            if (accommodationResponse.getIsDeleted()) {
                                responseStatus = true;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Grpc exception happened");
                        } finally {
                            // Shutdown the gRPC channel
                            channel2.shutdown();
                            try {
                                channel2.awaitTermination(5, TimeUnit.SECONDS);
                            } catch (InterruptedException e) {
                                // Handle channel shutdown interruption
                                System.out.println("Shutdown interruption happened");
                            }
                        }


                        if (responseStatus) {
                            service.delete(user);
                            return new ResponseEntity<>(HttpStatus.OK);
                        } else {
                            throw new UserHaveActiveReservationsException();
                        }
                    } else {
                        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                    }
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

    @GetMapping("/host/{id}")
    public ResponseEntity<User> getHostById(@PathVariable Long id) {
        User user = service.find(id);
        if (user != null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<User> getGuestById(@PathVariable Long id) {
        User user = service.find(id);
        if (user != null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username) {
        System.out.println(username);
        User user = service.find(username);
        if (user != null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/distinguishedHost/{hostId}")
    public ResponseEntity<Boolean> getDistinguishedHostStatus(@PathVariable Long hostId){
        User user = service.find(hostId);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean responseStatus = false;
        //-------------------------------------------Grpc begin to rating service----------------------------------------------
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9099)
                .usePlaintext()
                .build();

        ManageUserServiceGrpc.ManageUserServiceBlockingStub stub = ManageUserServiceGrpc.newBlockingStub(channel);
        try {
            AccountRating.DistinguishedHostRatingRequest request = AccountRating.DistinguishedHostRatingRequest.newBuilder()
                    .setHostId(user.getId())
                    .build();

            AccountRating.DistinguishedHostRatingResponse response = stub.getDistinguishedHostStatusFromRatings(request);
            if (response.getIsDistinguished()) {
                responseStatus = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Grpc exception happened");
        } finally {
            channel.shutdown();
        }
        //-------------------------------------------Grpc end ----------------------------------------------
        if (responseStatus){
            user.setDistinguishedHost(true);
            service.save(user);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else {
            user.setDistinguishedHost(false);
            service.save(user);
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
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
        user.setDistinguishedHost(false);

    }

    private boolean isUserDetailsRequestValid(UserDetailsRequest dto) {
        return !isBlank(dto.getUsername()) && !isBlank(dto.getPassword())
                && !isBlank(dto.getName()) && !isBlank(dto.getSurname())
                && !isBlank(dto.getEmail()) && !isBlank(dto.getCountry())
                && !isBlank(dto.getCity()) && !isBlank(dto.getStreet())
                && !isBlank(dto.getNumber()) && !isBlank(dto.getRoleName());
    }
}
