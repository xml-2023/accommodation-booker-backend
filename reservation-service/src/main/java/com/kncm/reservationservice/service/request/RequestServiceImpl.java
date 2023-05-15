package com.kncm.reservationservice.service.request;

import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.model.ReservationRequest;
import com.kncm.reservationservice.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<ReservationRequest> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public ReservationRequest findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(ReservationRequest request) {
        repository.save(request);
    }

    @Override
    public List<ReservationRequest> findByStatus(RequestStatus status) {
        return repository.findByStatus(status);
    }

    @Override
    public void rejectRequests(LocalDateTime from, LocalDateTime to) {
        List<ReservationRequest> pendingRequests = findByStatus(RequestStatus.PENDING);
        for (ReservationRequest request : pendingRequests) {
            if (from.isBefore(request.getReserveTo()) && to.isAfter(request.getReserveFrom()) ||
                from.isEqual(request.getReserveFrom()) || to.isEqual(request.getReserveTo())) {
                request.setStatus(RequestStatus.REJECTED);
                save(request);
            }
        }
    }

    @Override
    public void delete(ReservationRequest request) {
        repository.delete(request);
    }
}
