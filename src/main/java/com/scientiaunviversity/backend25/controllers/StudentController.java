package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.domain.User;
import com.scientiaunviversity.backend25.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

}
