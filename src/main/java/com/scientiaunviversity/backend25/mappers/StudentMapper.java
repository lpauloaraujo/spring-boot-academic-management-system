package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.StudentResponseDTO;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.domain.Subject;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    public StudentResponseDTO toResponse(Student student) {

        List<String> enrolledSubjectsNames = new ArrayList<>();
        for (SubjectEnrollment subjectEnrollment : student.getSubjectEnrollments()) {
            String subjectName = subjectEnrollment.getClassGroup().getSubject().getName();
            enrolledSubjectsNames.add(subjectName);
            }

        return new StudentResponseDTO(
                student.getUserId(),
                student.getFullName(),
                student.getEmail(),
                student.getRegistrationNumber(),
                student.getCourseEnrollment().getCourse().getName(),
                enrolledSubjectsNames
        );
    }
}
