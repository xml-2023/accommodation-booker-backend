package com.kncm.reservationservice.service.request;

import com.kncm.reservationservice.model.ReservationRequest;
import com.kncm.reservationservice.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository repository;

    @Override
    public void createRequest(ReservationRequest request) {
        repository.save(request);
    }

}
