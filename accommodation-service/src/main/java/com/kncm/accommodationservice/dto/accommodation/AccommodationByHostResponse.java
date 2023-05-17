package com.kncm.accommodationservice.dto.accommodation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccommodationByHostResponse {
    private Long id;
    private String name;
    private String description;
    private String country;
    private String city;
    private String street;
    private String number;
}
