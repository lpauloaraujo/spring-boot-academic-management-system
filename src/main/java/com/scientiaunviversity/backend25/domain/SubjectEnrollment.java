package com.scientiaunviversity.backend25.domain;

import com.scientiaunviversity.backend25.domain.enums.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class SubjectEnrollment {

    @EmbeddedId
    private EnrollmentId id;

    @Column(name = "enrollment_code", unique = true, nullable = false)
    private String enrollmentCode;

    @OneToOne
    @MapsId("studentId")
    @JoinColumn(name = "user_id")
    private Student student;

    @ManyToOne
    @MapsId("classGroupId")
    @JoinColumn(name = "class_group_id")
    private ClassGroup classGroup;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    @Column(name = "grade")
    private BigDecimal grade;

}
