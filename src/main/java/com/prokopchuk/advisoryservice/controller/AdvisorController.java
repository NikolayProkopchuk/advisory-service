package com.prokopchuk.advisoryservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.prokopchuk.advisoryservice.dto.ApplicationDto;
import com.prokopchuk.advisoryservice.entity.Application;
import com.prokopchuk.advisoryservice.repository.AdvisorRepo;
import com.prokopchuk.advisoryservice.service.AdvisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advisory")
@RequiredArgsConstructor
public class AdvisorController {

    private final AdvisorService advisorService;

    @PostMapping("/assign")
    @Transactional
    public ResponseEntity<ApplicationDto> assignApplication(@RequestBody JsonNode body) {
        var advisor = advisorService.findAdvisorById(body.get("advisorId").asLong());
        var applicationDto = advisorService.assignApplicationToAdvisor(advisor);

        return ResponseEntity.ok(applicationDto);
    }

}
