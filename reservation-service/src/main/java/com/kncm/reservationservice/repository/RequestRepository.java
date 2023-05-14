package com.kncm.reservationservice.repository;

import com.kncm.reservationservice.model.ReservationRequest;
import java.util.List;

public interface RequestRepository extends EntityRepository<ReservationRequest>{
    List<ReservationRequest> findByAccommodationId(Long accommodationId);
}