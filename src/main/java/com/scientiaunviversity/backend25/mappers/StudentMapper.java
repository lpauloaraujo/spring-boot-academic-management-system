package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.request.StudentRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.StudentResponseDTO;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDTO studentRequestDTO) {
        if (studentRequestDTO == null) return null;

        Student student = new Student();

        student.setFullName(studentRequestDTO.getFullName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setPassword(studentRequestDTO.getPassword());
        student.setCpf(studentRequestDTO.getCpf());
        student.setRegistrationNumber(studentRequestDTO.getRegistrationNumber());

        return student;

    }

    public StudentResponseDTO toResponse(Student student) {

        List<String> enrolledSubjectsNames = new ArrayList<>();
        for (SubjectEnrollment subjectEnrollment : student.getSubjectEnrollments()) {
            String subjectName = subjectEnrollment.getClassGroup().getSubject().getName();
            enrolledSubjectsNames.add(subjectName);
            }

        String courseName = null;

        if (student.getCourseEnrollment() != null) {
            courseName = student.getCourseEnrollment()
                    .getCourse()
                    .getName();
        }

        return new StudentResponseDTO(
                student.getUserId(),
                student.getFullName(),
                student.getEmail(),
                student.getRegistrationNumber(),
                courseName,
                enrolledSubjectsNames
        );
    }
}
