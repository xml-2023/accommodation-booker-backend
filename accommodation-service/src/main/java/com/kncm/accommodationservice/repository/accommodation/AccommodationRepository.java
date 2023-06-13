package com.kncm.accommodationservice.repository.accommodation;

import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.repository.EntityRepository;

import java.util.List;

public interface AccommodationRepository extends EntityRepository<Accommodation> {
    List<Accommodation> findByUserId(Long userId);

    Accommodation findByName(String name);
}
