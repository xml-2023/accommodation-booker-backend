package com.kncm.accommodationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationTestDTO {
    private String name;
    private Integer minGuests;
    private Integer maxGuests;
    private String description;
    private boolean isAutomaticConfirmation;
}
