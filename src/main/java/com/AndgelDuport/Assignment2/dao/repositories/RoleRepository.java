package com.AndgelDuport.Assignment2.dao.repositories;

import com.AndgelDuport.Assignment2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String roleName);
}
