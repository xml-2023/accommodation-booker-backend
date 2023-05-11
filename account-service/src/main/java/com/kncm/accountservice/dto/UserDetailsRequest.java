package com.kncm.accountservice.dto;

import lombok.Data;

@Data
public class UserDetailsRequest {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String country;
    private String city;
    private String street;
    private String number;
    private String roleName;
}
