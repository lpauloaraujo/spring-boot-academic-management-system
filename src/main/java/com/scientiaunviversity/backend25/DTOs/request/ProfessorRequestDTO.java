package com.scientiaunviversity.backend25.DTOs.request;

import com.scientiaunviversity.backend25.domain.enums.AcademicDegree;
import com.scientiaunviversity.backend25.domain.enums.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorRequestDTO {

    @NotBlank
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String cpf;

    @NotBlank
    private String registrationNumber;

    @NotBlank
    private AcademicDegree academicDegree;

    @NotBlank
    private Department department;
}
