package com.kncm.accommodationservice.service.accommodation;

import com.kncm.accommodationservice.model.Accommodation;

import java.util.Collection;
import java.util.Optional;

public interface AccommodationService {
    void create(Accommodation accommodation);
    void update(Accommodation accommodation);
    Accommodation findById(Long id);
    Collection<Accommodation> search(String location, Integer numOfGuests, String startDate, String endDate);
}
