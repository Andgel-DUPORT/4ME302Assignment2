package com.AndgelDuport.Assignment2.dao.repositories;

import com.AndgelDuport.Assignment2.dao.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String roleName);

    Optional<Role> findByRoleID(Integer role_iDrole);
}
