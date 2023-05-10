package com.kncm.accountservice.controller;

import com.kncm.accountservice.dto.RegisterUserRequest;
import com.kncm.accountservice.handler.exceptions.UsernameIsNotUniqueException;
import com.kncm.accountservice.model.Address;
import com.kncm.accountservice.model.User;
import com.kncm.accountservice.service.RoleService;
import com.kncm.accountservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final UserService service;
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RegisterUserRequest dto){
        User user = new User();
        Map(dto, user);
        if (!service.exists(user.getUsername())) {
            service.create(user);
        } else {
            throw new UsernameIsNotUniqueException();
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private void Map(RegisterUserRequest dto, User user){
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
}
