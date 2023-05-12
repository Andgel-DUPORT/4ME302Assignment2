package com.AndgelDuport.Assignment2.dao.repositories;

import com.AndgelDuport.Assignment2.dao.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByOrganizationID(Integer organization);
}
