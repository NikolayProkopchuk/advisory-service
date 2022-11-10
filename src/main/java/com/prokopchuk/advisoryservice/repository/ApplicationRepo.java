package com.prokopchuk.advisoryservice.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.prokopchuk.advisoryservice.entity.Application;
import com.prokopchuk.advisoryservice.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
    Optional<Application> findFirstByApplicationStatusAndAmountBetweenAndAdvisorIsNullOrderByCreatedAt(
      ApplicationStatus applicationStatus, BigDecimal from, BigDecimal to);
}
