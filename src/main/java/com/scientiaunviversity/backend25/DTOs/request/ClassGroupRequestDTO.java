package com.scientiaunviversity.backend25.DTOs.request;

import com.scientiaunviversity.backend25.domain.enums.ClassGroupStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassGroupRequestDTO {
    @NotBlank
    private Long subjectId;

    @NotBlank
    private String code;

    @NotBlank
    private String semester;

    @NotBlank
    private Integer maxStudents;

    @NotBlank
    private ClassGroupStatus status;
}
