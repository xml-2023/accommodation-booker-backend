package com.kncm.accountservice.controller;

import com.kncm.accountservice.dto.UserDetailsRequest;
import com.kncm.accountservice.handler.exceptions.UserDetailsRequestIsNotValidException;
import com.kncm.accountservice.handler.exceptions.UserWithPassedIdDoesNotExistException;
import com.kncm.accountservice.handler.exceptions.UsernameIsNotUniqueException;
import com.kncm.accountservice.model.Address;
import com.kncm.accountservice.model.User;
import com.kncm.accountservice.service.RoleService;
import com.kncm.accountservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.apache.commons.lang.StringUtils.isBlank;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final UserService service;
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserDetailsRequest dto) {
        if (isUserDetailsRequestValid(dto)) {
            User user = new User();
            Map(dto, user);
            if (!service.exists(user.getUsername())) {
                service.save(user);
            } else {
                throw new UsernameIsNotUniqueException();
            }

            return new ResponseEntity<>(HttpStatus.CREATED);
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
                    Map(dto, user);
                    service.save(user);
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

    private void Map(UserDetailsRequest dto, User user){
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
