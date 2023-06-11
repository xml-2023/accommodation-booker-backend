package com.kncm.ratingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Role role;
}
