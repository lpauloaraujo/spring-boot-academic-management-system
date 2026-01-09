package com.scientiaunviversity.backend25.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private CourseEnrollment courseEnrollment;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubjectEnrollment> subjectEnrollments = new HashSet<>();
}
