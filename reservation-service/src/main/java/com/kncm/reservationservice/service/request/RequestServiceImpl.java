package com.kncm.reservationservice.service.request;

import com.kncm.reservationservice.model.ReservationRequest;
import com.kncm.reservationservice.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository repository;

    @Override
    public void createRequest(ReservationRequest request) {
        repository.save(request);
    }

    @Override
    public List<ReservationRequest> findByAccommodationId(Long accommodationId) {
        return repository.findByAccommodationId(accommodationId);
    }

    @Override
    public ReservationRequest findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(ReservationRequest request) {
        repository.save(request);
    }
}
