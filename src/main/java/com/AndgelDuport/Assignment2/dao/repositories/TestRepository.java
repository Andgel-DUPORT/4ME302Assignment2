package com.AndgelDuport.Assignment2.dao.repositories;

import com.AndgelDuport.Assignment2.dao.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
