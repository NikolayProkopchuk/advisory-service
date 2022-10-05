package com.prokopchuk.advisoryservice.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "applicants")
public class Applicant extends SystemUser {
    private String ssn;

    @Embedded
    private Address address;

    @Setter(AccessLevel.PRIVATE)
    @ElementCollection
    private List<Phone> phones = new ArrayList<>();

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    @OneToMany(mappedBy = "applicant")
    @Setter(AccessLevel.PRIVATE)
    @ToString.Exclude
    private List<Application> applications;

    public void apply(Application application) {
        applications.add(application);
        application.setApplicant(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Applicant applicant = (Applicant) o;
        return getUsername() != null && Objects.equals(getUsername(), applicant.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}
