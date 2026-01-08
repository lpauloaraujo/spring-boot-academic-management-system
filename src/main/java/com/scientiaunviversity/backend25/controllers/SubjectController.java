package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.domain.Subject;
import com.scientiaunviversity.backend25.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAll() {return subjectService.getAll();}

    @GetMapping("/{id}")
    public Subject getById(@PathVariable Long id) {
        return subjectService.getById(id);
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return subjectService.create(subject);
    }
}
