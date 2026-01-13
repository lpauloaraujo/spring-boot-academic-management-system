package com.scientiaunviversity.backend25.DTOs.response;

import com.scientiaunviversity.backend25.domain.EnrollmentId;
import com.scientiaunviversity.backend25.domain.enums.EnrollmentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SubjectEnrollmentResponseDTO(
        EnrollmentId id,
        String enrollmentCode,
        String studentName,
        Long classGroupId,
        String subjectName,
        LocalDate enrollmentDate,
        EnrollmentStatus status,
        BigDecimal grade
) {
}
