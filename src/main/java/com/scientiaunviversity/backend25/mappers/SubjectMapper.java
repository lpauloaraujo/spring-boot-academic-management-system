package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.SubjectResponseDTO;
import com.scientiaunviversity.backend25.domain.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public SubjectResponseDTO toResponse(Subject subject) {

        return new SubjectResponseDTO(
                subject.getId(),
                subject.getName(),
                subject.getCourse().getName(),
                subject.getProfessor().getFullName()
        );
    }
}
