package com.scientiaunviversity.backend25.domain;

import com.scientiaunviversity.backend25.domain.enums.AcademicDegree;
import com.scientiaunviversity.backend25.domain.enums.Department;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Professor extends User {

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToMany(mappedBy = "professor")
    private Set<Subject> subjects = new HashSet<>();
}
