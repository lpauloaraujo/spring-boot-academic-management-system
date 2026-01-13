package com.scientiaunviversity.backend25.DTOs.request;

import com.scientiaunviversity.backend25.domain.enums.ClassGroupStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseEnrollmentRequestDTO {

    @NotBlank
    private Long studentId;

    @NotBlank
    private Long courseId;

    @NotBlank
    private String enrollmentCode;

}
