package com.scientiaunviversity.backend25.DTOs;

import java.util.Set;

public record CourseResponseDTO(
        Long id,
        String courseName,
        Set<String> subjectNames
) { }
