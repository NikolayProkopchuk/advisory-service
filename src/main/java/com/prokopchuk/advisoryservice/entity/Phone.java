package com.prokopchuk.advisoryservice.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Embeddable
@Data
public class Phone {

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    private enum PhoneType {
        HOME, WORK, MOBILE;
    }
}
