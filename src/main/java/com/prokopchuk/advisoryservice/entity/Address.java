package com.prokopchuk.advisoryservice.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
    private String city;

    private String street;

    private int number;

    private int zip;

    private int apt;
}
