package com.scientiaunviversity.backend25.DTOs.request;

import com.scientiaunviversity.backend25.domain.enums.EnrollmentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SubjectEnrollmentRequestDTO {

    @NotBlank
    private String enrollmentCode;

    @NotBlank
    private Long studentId;

    @NotBlank
    private Long classGroupId;

    @NotBlank
    private LocalDate enrollmentDate;

    @NotNull
    private EnrollmentStatus enrollmentStatus;

    @NotBlank
    private BigDecimal grade;
}
