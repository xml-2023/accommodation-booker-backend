package com.kncm.accommodationservice.service.user;

import com.kncm.accommodationservice.model.User;
import com.kncm.accommodationservice.repository.user.UserRepository;
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
