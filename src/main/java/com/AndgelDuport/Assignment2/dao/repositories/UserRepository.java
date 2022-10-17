package com.AndgelDuport.Assignment2.dao.repositories;

import com.AndgelDuport.Assignment2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
