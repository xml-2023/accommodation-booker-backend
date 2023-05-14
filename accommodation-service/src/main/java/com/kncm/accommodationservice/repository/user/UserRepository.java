package com.kncm.accommodationservice.repository.user;

import com.kncm.accommodationservice.model.User;
import com.kncm.accommodationservice.repository.EntityRepository;

public interface UserRepository extends EntityRepository<User> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}
