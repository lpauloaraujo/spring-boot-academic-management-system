package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.ClassGroupResponseDTO;
import com.scientiaunviversity.backend25.domain.ClassGroup;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ClassGroupMapper {

    public ClassGroupResponseDTO toResponse(ClassGroup classGroup) {

        Set<SubjectEnrollment> subjectEnrollmentList = classGroup.getSubjectEnrollments();
        Set<String> subjectEnrollmentCodesList = new HashSet<>();
        for (SubjectEnrollment subjectEnrollment : subjectEnrollmentList) {
            subjectEnrollmentCodesList.add(subjectEnrollment.getEnrollmentCode());
        }

        return new ClassGroupResponseDTO(
                classGroup.getClassGroupId(),
                classGroup.getSubject().getName(),
                classGroup.getCourse().getName(),
                classGroup.getProfessor().getFullName(),
                classGroup.getCode(),
                classGroup.getSemester(),
                classGroup.getMaxStudents(),
                classGroup.getStatus(),
                subjectEnrollmentCodesList,
                classGroup.getCreatedAt(),
                classGroup.getUpdatedAt()
        );
    }
}
