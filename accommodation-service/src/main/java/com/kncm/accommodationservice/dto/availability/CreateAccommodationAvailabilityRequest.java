package com.kncm.accommodationservice.dto.availability;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAccommodationAvailabilityRequest {
    private String from;
    private String to;
    private Long accommodationId;
    private double priceInEuros;
}
