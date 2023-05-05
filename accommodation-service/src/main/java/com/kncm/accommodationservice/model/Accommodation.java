package com.kncm.accommodationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("accommodations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {
    @Transient
    public static final String SEQUENCE_NAME = "accommodation_sequence";
    @Id
    private Long id;
    private String name;
    private Integer minGuests;
    private Integer maxGuests;
    private String description;
    private boolean isAutomaticConfirmation;
    private Address address;
    private ArrayList<Image> images;
    private ArrayList<AccommodationPrice> prices;
    private ArrayList<AccommodationAvailability> availableSlots;
}
