package com.scientiaunviversity.backend25.DTOs.request;

import com.scientiaunviversity.backend25.domain.enums.AcademicDegree;
import com.scientiaunviversity.backend25.domain.enums.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private AcademicDegree academicDegree;

    @NotNull
    private Department department;
}
