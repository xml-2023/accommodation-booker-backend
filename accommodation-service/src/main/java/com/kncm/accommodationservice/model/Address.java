package com.kncm.accommodationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document("addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    //    private Long id;
    private String country;
    private String city;
    private String street;
    private String number;
}
