package com.kncm.accountservice.service;

import com.kncm.accountservice.model.User;
import com.kncm.accountservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public boolean exists(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public User find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public User find(String username) {
        return repository.findByUsername(username);
    }


}
