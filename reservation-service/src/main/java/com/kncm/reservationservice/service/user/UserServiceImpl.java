package com.kncm.reservationservice.service.user;

import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.model.ReservationRequest;
import com.kncm.reservationservice.model.User;
import com.kncm.reservationservice.repository.RequestRepository;
import com.kncm.reservationservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final RequestRepository requestRepository;

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public boolean haveActiveReservations(Long userId) {
        for (ReservationRequest r : requestRepository.findByUserId(userId)) {
            if (r.getStatus() == RequestStatus.ACCEPTED) {
                return true;
            }
        }
        return false;
    }
}
