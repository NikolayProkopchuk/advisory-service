package com.prokopchuk.advisoryservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.prokopchuk.advisoryservice.entity.ApplicationStatus;
import lombok.Data;

@Data
public class ApplicationDto{
    private long id;

    private BigDecimal amount;

    private ApplicationStatus applicationStatus;

    private LocalDateTime createdAt;

    private LocalDateTime assignedAt;

    private LocalDateTime resolvedAt;
}
