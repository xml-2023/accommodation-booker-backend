package com.kncm.accountservice.service;

import com.kncm.accountservice.model.Role;
import com.kncm.accountservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role find(String name) {
        return repository.findByName(name);
    }
}
