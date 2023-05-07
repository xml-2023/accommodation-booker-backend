package com.kncm.accommodationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("acc_availabilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationAvailability {
    @Transient
    public static final String SEQUENCE_NAME = "accommodation_availability_sequence";
    @Id
    private Long id;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;
}
