package com.scientiaunviversity.backend25.DTOs;

public record SubjectResponseDTO(
        Long id,
        String name,
        String courseName,
        String professorName
) {
}
