package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.ClassGroup;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import com.scientiaunviversity.backend25.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    @Transactional
    public Student create(Student student) {

        if (student.getCourseEnrollment() != null) {
            student.getCourseEnrollment().setStudent(student);
        }

        if (student.getSubjectEnrollments() != null) {
            for (SubjectEnrollment se : student.getSubjectEnrollments()) {
                se.setStudent(student);
            }
        }

        return studentRepository.save(student);
    }

}
