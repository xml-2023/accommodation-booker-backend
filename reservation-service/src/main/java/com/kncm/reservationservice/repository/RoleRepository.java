package com.kncm.reservationservice.repository;

import com.kncm.reservationservice.model.Role;

public interface RoleRepository extends EntityRepository<Role> {
    Role findByName(String name);

}
