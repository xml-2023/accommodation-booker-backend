package com.kncm.reservationservice.repository;

import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.model.ReservationRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends EntityRepository<ReservationRequest>{
    List<ReservationRequest> findByAccommodationId(Long accommodationId);

    List<ReservationRequest> findByUserId(Long userId);
    @Modifying
    @Query("DELETE FROM ReservationRequest rr WHERE rr.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);

    List<ReservationRequest> findByStatus(RequestStatus status);

    List<ReservationRequest> findByUserIdAndAccommodationIdAndStatus(Long userId, Long accommodationId, RequestStatus status);
    List<ReservationRequest> findByUserIdAndStatusAndAccommodation_HostId(Long guestId, RequestStatus status, Long hostId);


}
