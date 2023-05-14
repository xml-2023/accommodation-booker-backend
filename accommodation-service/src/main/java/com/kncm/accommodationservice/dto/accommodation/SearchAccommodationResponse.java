package com.kncm.accommodationservice.dto.accommodation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchAccommodationResponse {
    private Long id;
    private String name;
    private Integer minGuests;
    private Integer maxGuests;
    private String description;
    private String country;
    private String city;
    private String street;
    private String number;
    private double totalPrice;
    private double unitPrice;
    private String startDate;
    private String endDate;
}
