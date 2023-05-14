package com.kncm.accommodationservice.repository.role;

import com.kncm.accommodationservice.model.Role;
import com.kncm.accommodationservice.repository.EntityRepository;

public interface RoleRepository extends EntityRepository<Role> {
    Role findByName(String name);
}
