package com.kncm.accommodationservice.service.accommodation;

import com.kncm.accommodationservice.dto.accommodation.SearchAccommodationResponse;
import com.kncm.accommodationservice.model.Accommodation;

import java.util.Collection;
import java.util.List;

public interface AccommodationService {
    void create(Accommodation accommodation);

    void update(Accommodation accommodation);

    Accommodation findById(Long id);

    Collection<SearchAccommodationResponse> search(String location, Integer numOfGuests, String startDate, String endDate);
    List<Accommodation> findByUserId(Long userId);
}
