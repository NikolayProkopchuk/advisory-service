package com.prokopchuk.advisoryservice.service;

import com.prokopchuk.advisoryservice.dto.ApplicationDto;
import com.prokopchuk.advisoryservice.entity.Advisor;
import com.prokopchuk.advisoryservice.entity.Application;
import com.prokopchuk.advisoryservice.exception.AdvisorNotFoundException;
import com.prokopchuk.advisoryservice.exception.AdvisoryException;
import com.prokopchuk.advisoryservice.mapper.ApplicationMapper;
import com.prokopchuk.advisoryservice.repository.AdvisorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvisorService {

    private final ApplicationService applicationService;

    private final AdvisorRepo advisorRepo;

    public Advisor findAdvisorById(long id) {
        return advisorRepo.findById(id).orElseThrow(() -> new AdvisorNotFoundException("Advisor not found by id: " + id));
    }

    public ApplicationDto assignApplicationToAdvisor(Advisor advisor) {
        if (advisor.isAvailableForNewApplications()) {
            var availableApplication = applicationService.getAvailableApplication(advisor);
            var application = advisor.assignApplication(availableApplication);
            return ApplicationMapper.INSTANCE.applicationToApplicationDto(application);
        }
        throw new AdvisoryException(String.format("Advisor %s has assigned application", advisor));
    }
}
