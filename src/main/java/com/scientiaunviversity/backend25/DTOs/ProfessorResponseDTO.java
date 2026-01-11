package com.scientiaunviversity.backend25.DTOs;

import com.scientiaunviversity.backend25.domain.enums.AcademicDegree;
import com.scientiaunviversity.backend25.domain.enums.Department;

import java.util.List;

public record ProfessorResponseDTO (
        Long id,
        String fullName,
        String email,
        String registrationNumber,
        AcademicDegree academicDegree,
        Department department,
        List<String> subjectNames
) { }
