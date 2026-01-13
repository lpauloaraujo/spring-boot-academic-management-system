package com.scientiaunviversity.backend25.DTOs.response;

import java.util.List;

public record StudentResponseDTO(
        Long id,
        String fullName,
        String email,
        String registrationNumber,
        String courseName,
        List<String> enrolledSubjectsNames
) {}
