package com.kncm.accommodationservice.service.accommodation;

import com.kncm.accommodationservice.model.Accommodation;

import java.util.Collection;

public interface AccommodationService {
    void create(Accommodation accommodation);
    Collection<Accommodation> search(String location, Integer numOfGuests, String startDate, String endDate);
}
