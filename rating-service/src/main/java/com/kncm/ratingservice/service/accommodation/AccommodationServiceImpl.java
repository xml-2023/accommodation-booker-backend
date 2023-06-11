package com.kncm.ratingservice.service.accommodation;

import com.kncm.ratingservice.model.Accommodation;
import com.kncm.ratingservice.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService{
    private final AccommodationRepository repository;
    @Override
    public Accommodation findOne(Long id) {
        return repository.findOne(id);
    }
}
