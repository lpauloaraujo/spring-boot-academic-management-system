package com.scientiaunviversity.backend25.DTOs.request;

import com.scientiaunviversity.backend25.domain.enums.ClassGroupStatus;
import com.scientiaunviversity.backend25.domain.enums.CourseEnrollmentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CourseEnrollmentRequestDTO {

    @NotBlank
    private Long studentId;

    @NotBlank
    private Long courseId;

    @NotBlank
    private String enrollmentCode;

    private LocalDate admissionDate;

    @NotNull
    private CourseEnrollmentStatus courseEnrollmentStatus;

}
