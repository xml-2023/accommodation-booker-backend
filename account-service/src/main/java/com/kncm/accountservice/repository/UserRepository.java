package com.kncm.accountservice.repository;

import com.kncm.accountservice.model.User;

public interface UserRepository extends EntityRepository<User> {
    boolean existsByUsername(String username);
}
