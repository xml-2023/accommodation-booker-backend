package com.kncm.reservationservice.repository;


import com.kncm.reservationservice.model.User;

public interface UserRepository extends EntityRepository<User> {
    boolean existsByUsername(String username);

    User findByUsername(String username);
}
