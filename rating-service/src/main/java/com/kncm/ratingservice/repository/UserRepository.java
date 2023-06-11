package com.kncm.ratingservice.repository;

import com.kncm.ratingservice.model.User;

public interface UserRepository extends EntityRepository<User> {
    boolean existsByUsername(String username);

    User findByUsername(String username);
}
