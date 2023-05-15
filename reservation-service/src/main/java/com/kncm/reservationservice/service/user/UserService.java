package com.kncm.reservationservice.service.user;

import com.kncm.reservationservice.model.User;

public interface UserService {
    User findOne(Long id);
    boolean haveActiveReservations(Long userId);
}
