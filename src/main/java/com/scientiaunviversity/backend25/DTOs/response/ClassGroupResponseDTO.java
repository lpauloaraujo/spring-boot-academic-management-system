package com.scientiaunviversity.backend25.DTOs.response;

import com.scientiaunviversity.backend25.domain.enums.ClassGroupStatus;

import java.time.LocalDateTime;
import java.util.Set;

public record ClassGroupResponseDTO(
        Long id,
        String subjectName,
        String courseName,
        String professorName,
        String code,
        String semester,
        Integer maxStudents,
        ClassGroupStatus status,
        Set<String> subjectEnrollmentCodes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
