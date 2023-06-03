package com.kncm.reservationservice.service.request;

import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.model.ReservationRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestService {
    void createRequest(ReservationRequest request);
    List<ReservationRequest> findByAccommodationId(Long accommodationId);
    List<ReservationRequest> findByUserId(Long userId);
    ReservationRequest findOne(Long id);
    void save(ReservationRequest request);
    List<ReservationRequest> findByStatus(RequestStatus status);
    void rejectRequests(LocalDateTime from, LocalDateTime to);
    void delete(ReservationRequest request);
    boolean isAllowedToRate(Long userId, Long accommodationId, RequestStatus status);
}
