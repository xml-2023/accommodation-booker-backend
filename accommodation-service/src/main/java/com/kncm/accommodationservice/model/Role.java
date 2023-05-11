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
@Document("roles")
public class Role {
    @Transient
    public static final String SEQUENCE_NAME = "role_sequence";
    @Id
    private Long id;
    private String name;
}