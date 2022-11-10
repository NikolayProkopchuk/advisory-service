package com.prokopchuk.advisoryservice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Table(name = "applications")
@Getter
@Setter
@ToString(of = {"id", "amount", "applicationStatus", "createdAt", "assignedAt", "resolvedAt"})
@RequiredArgsConstructor
public class Application {

    @Id
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus = ApplicationStatus.NEW;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime assignedAt;

    private LocalDateTime resolvedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Application that = (Application) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
