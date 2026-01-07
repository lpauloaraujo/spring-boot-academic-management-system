package com.scientiaunviversity.backend25.domain;

import com.scientiaunviversity.backend25.domain.enums.CourseEnrollmentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CourseEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "admission_data")
    private LocalDate admissionDate;

    @Enumerated(EnumType.STRING)
    private CourseEnrollmentStatus status;
}
