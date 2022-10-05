package com.prokopchuk.advisoryservice.repository;

import com.prokopchuk.advisoryservice.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepo extends JpaRepository<Advisor, Long> {

}
