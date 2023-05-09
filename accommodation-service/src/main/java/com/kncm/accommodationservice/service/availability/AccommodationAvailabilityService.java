package com.kncm.accommodationservice.service.availability;

import com.kncm.accommodationservice.model.AccommodationAvailability;

public interface AccommodationAvailabilityService {
    void create(AccommodationAvailability availability);
    void update(AccommodationAvailability availability);
    AccommodationAvailability findById(Long id);
}
