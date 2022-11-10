package com.prokopchuk.advisoryservice.service;

import com.prokopchuk.advisoryservice.entity.Advisor;
import com.prokopchuk.advisoryservice.entity.Application;
import com.prokopchuk.advisoryservice.entity.ApplicationStatus;
import com.prokopchuk.advisoryservice.exception.AdvisoryException;
import com.prokopchuk.advisoryservice.repository.ApplicationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepo applicationRepo;

    public Application getAvailableApplication(Advisor advisor) {
        return applicationRepo.findFirstByApplicationStatusAndAmountBetweenAndAdvisorIsNullOrderByCreatedAt(
            ApplicationStatus.NEW,
            advisor.getRole().getLowLimitWorkingAmount(),
            advisor.getRole().getTopLimitWorkingAmount())
          .orElseThrow(() -> new AdvisoryException("No available applications for advisor: " + advisor));
    }
}
