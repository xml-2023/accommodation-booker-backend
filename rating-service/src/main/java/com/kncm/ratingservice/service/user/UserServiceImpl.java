package com.kncm.ratingservice.service.user;

import com.kncm.ratingservice.model.User;
import com.kncm.ratingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }
}
