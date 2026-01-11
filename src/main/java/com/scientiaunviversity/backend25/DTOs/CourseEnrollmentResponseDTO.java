package com.scientiaunviversity.backend25.DTOs;

import com.scientiaunviversity.backend25.domain.enums.CourseEnrollmentStatus;

import java.time.LocalDate;

public record CourseEnrollmentResponseDTO(
        Long id,
        String enrollmentCode,
        String studentName,
        String courseName,
        LocalDate admissionDate,
        CourseEnrollmentStatus courseEnrollmentStatus
) { }
