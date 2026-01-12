package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.SubjectEnrollmentResponseDTO;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import org.springframework.stereotype.Component;

@Component
public class SubjectEnrollmentMapper {

    public SubjectEnrollmentResponseDTO toResponse(SubjectEnrollment subjectEnrollment) {

        return new SubjectEnrollmentResponseDTO(
                subjectEnrollment.getId(),
                subjectEnrollment.getEnrollmentCode(),
                subjectEnrollment.getStudent().getFullName(),
                subjectEnrollment.getClassGroup().getClassGroupId(),
                subjectEnrollment.getClassGroup().getSubject().getName(),
                subjectEnrollment.getEnrollmentDate(),
                subjectEnrollment.getStatus(),
                subjectEnrollment.getGrade()
        );

    }
}
