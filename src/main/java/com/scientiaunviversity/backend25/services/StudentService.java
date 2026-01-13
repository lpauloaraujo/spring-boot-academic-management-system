package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.DTOs.request.StudentRequestDTO;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import com.scientiaunviversity.backend25.mappers.StudentMapper;
import com.scientiaunviversity.backend25.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    @Transactional
    public Student create(StudentRequestDTO studentRequestDTO) {
        Student student = studentMapper.toEntity(studentRequestDTO);
        return studentRepository.save(student);
    }

    @Transactional
    public Student delete(Long id) {
        Student studentToDelete = getById(id);
        studentRepository.delete(studentToDelete);
        return studentToDelete;
    }
}
