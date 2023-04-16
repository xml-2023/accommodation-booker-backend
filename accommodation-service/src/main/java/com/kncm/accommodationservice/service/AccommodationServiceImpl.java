package com.kncm.accommodationservice.service;

import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService{
    private final AccommodationRepository accommodationRepository;
    @Override
    public void create(Accommodation accommodation) {
        accommodationRepository.save(accommodation);
    }
}
