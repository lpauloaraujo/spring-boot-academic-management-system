package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.request.StudentRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.StudentResponseDTO;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.mappers.StudentMapper;
import com.scientiaunviversity.backend25.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public List<StudentResponseDTO> getAll() {
        List<Student> studentList = studentService.getAll();
        List<StudentResponseDTO> studentResponseDTOSList = new ArrayList<>();
        for (Student student : studentList) {
            studentResponseDTOSList.add(studentMapper.toResponse(student));
        } return studentResponseDTOSList;
    }

    @GetMapping("/{studentId}")
    public StudentResponseDTO getById(@PathVariable Long studentId) {
        return studentMapper.toResponse(studentService.getById(studentId));
    }

    @PostMapping
    public StudentResponseDTO create(@RequestBody @Valid StudentRequestDTO studentRequestDTO) {
        return studentMapper.toResponse(studentService.create(studentRequestDTO));
    }

    @DeleteMapping("/{studentId}")
    public StudentResponseDTO delete(@PathVariable Long studentId) {
        return studentMapper.toResponse(studentService.delete(studentId));
    }

    @PutMapping("/{studentId}")
    public StudentResponseDTO update(@PathVariable Long studentId, @RequestBody @Valid StudentRequestDTO studentRequestDTO) {
        return studentMapper.toResponse(studentService.update(studentId, studentRequestDTO));
    }
}
