package com.kncm.ratingservice.repository;

import com.kncm.ratingservice.model.Role;

public interface RoleRepository extends EntityRepository<Role>{
    Role findByName(String name);
}
