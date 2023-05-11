package com.kncm.accommodationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("users")
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private String username;
    private String password;
    private String name;
    private String surname;
    private Role role;
}
