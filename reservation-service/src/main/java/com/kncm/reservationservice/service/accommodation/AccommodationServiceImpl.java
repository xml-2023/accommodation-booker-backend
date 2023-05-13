package com.kncm.reservationservice.service.accommodation;

import com.kncm.reservationservice.model.Accommodation;
import com.kncm.reservationservice.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService{
    private final AccommodationRepository repository;

    @Override
    public Accommodation find(Long id) {
        return repository.findOne(id);
    }

}
