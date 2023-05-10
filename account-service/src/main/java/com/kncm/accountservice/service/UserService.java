package com.kncm.accountservice.service;

import com.kncm.accountservice.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    void create(User user);

    boolean exists(String username);
}
