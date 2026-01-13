package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.request.ProfessorRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.ProfessorResponseDTO;
import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.domain.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorMapper {

    public Professor toEntity(ProfessorRequestDTO professorRequestDTO) {

        Professor professor = new Professor();
        professor.setFullName(professorRequestDTO.getFullName());
        professor.setEmail(professorRequestDTO.getEmail());
        professor.setPassword(professorRequestDTO.getPassword());
        professor.setCpf(professorRequestDTO.getCpf());
        professor.setRegistrationNumber(professorRequestDTO.getRegistrationNumber());
        professor.setAcademicDegree(professorRequestDTO.getAcademicDegree());
        professor.setDepartment(professorRequestDTO.getDepartment());
        return professor;

    }

    public ProfessorResponseDTO toResponse(Professor professor) {

        List<String> subjectsNames = new ArrayList<>();
        for (Subject subject : professor.getSubjects()) {
            subjectsNames.add(subject.getName());
        }

        return new ProfessorResponseDTO(
                professor.getUserId(),
                professor.getFullName(),
                professor.getEmail(),
                professor.getRegistrationNumber(),
                professor.getAcademicDegree(),
                professor.getDepartment(),
                subjectsNames
        );
    }
}
