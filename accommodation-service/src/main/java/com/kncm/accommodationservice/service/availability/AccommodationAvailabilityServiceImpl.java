package com.kncm.accommodationservice.service.availability;

import com.kncm.accommodationservice.model.AccommodationAvailability;
import com.kncm.accommodationservice.repository.availability.AccommodationAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationAvailabilityServiceImpl implements AccommodationAvailabilityService {
    private final AccommodationAvailabilityRepository repository;

    @Override
    public void create(AccommodationAvailability availability) {
        repository.save(availability);
    }

    @Override
    public void update(AccommodationAvailability availability) {
        repository.save(availability);
    }

    @Override
    public AccommodationAvailability findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
