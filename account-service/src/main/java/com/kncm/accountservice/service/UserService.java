package com.kncm.accountservice.service;

import com.kncm.accountservice.model.User;

public interface UserService {
    void save(User user);

    boolean exists(String username);

    User find(Long id);
}
