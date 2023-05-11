package com.kncm.accountservice.repository;

import com.kncm.accountservice.model.Role;

public interface RoleRepository extends EntityRepository<Role> {
    Role findByName(String name);
}
