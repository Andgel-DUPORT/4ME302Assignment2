package com.AndgelDuport.Assignment2.dao.repositories;

import com.AndgelDuport.Assignment2.dao.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
