package com.kncm.reservationservice.service.request;

import com.kncm.reservationservice.model.ReservationRequest;

import java.util.List;

public interface RequestService {
    void createRequest(ReservationRequest request);
    List<ReservationRequest> findByAccommodationId(Long accommodationId);
    ReservationRequest findOne(Long id);
    void save(ReservationRequest request);
}
