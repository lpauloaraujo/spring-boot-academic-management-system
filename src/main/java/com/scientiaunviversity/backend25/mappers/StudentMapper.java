package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.ProfessorResponseDTO;
import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.domain.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

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
