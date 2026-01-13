package com.scientiaunviversity.backend25.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private Long courseId;

    @NotBlank
    private Long professorId;

}
