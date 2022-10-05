package com.prokopchuk.advisoryservice.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Table(name = "advisors")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Advisor extends SystemUser {

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "advisor")
    @ToString.Exclude
    @Setter(AccessLevel.PRIVATE)
    private List<Application> applications = new ArrayList<>();

    public boolean isAvailableForNewApplications() {
        return applications.stream().noneMatch(a -> a.getApplicationStatus().equals(ApplicationStatus.ASSIGNED));
    }

    public Application assignApplication(Application application) {
        applications.add(application);
        application.setAdvisor(this);
        application.setApplicationStatus(ApplicationStatus.ASSIGNED);
        application.setAssignedAt(LocalDateTime.now());
        return application;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Advisor advisor = (Advisor) o;
        return getUsername() != null && Objects.equals(getUsername(), advisor.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}
