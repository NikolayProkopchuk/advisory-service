package com.prokopchuk.advisoryservice.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    ASSOCIATE(BigDecimal.ZERO, BigDecimal.valueOf(9999)),
    PARTNER(BigDecimal.valueOf(10_000L), BigDecimal.valueOf(50_000)),
    SENIOR(BigDecimal.valueOf(50_000), BigDecimal.valueOf(100_000));


    private final BigDecimal lowLimitWorkingAmount;
    private final BigDecimal topLimitWorkingAmount;
}
