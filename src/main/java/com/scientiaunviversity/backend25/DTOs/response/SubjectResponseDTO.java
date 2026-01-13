package com.scientiaunviversity.backend25.DTOs.response;

public record SubjectResponseDTO(
        Long id,
        String name,
        String courseName,
        String professorName
) {
}
