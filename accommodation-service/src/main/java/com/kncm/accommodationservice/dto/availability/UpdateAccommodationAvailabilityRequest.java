package com.kncm.accommodationservice.dto.availability;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UpdateAccommodationAvailabilityRequest {
    private Long id;
    private String availableFrom;
    private String availableTo;
    private double priceInEuros;
    private Long accommodationId;
}
