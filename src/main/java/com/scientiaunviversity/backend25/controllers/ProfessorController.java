package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {this.professorService = professorService;}

    @GetMapping
    public List<Professor> getAll() {return professorService.getAll();}

    @GetMapping("/{id}")
    public Professor getById(@PathVariable Long id) {return professorService.getById(id);}

    @PostMapping
    public Professor create(@RequestBody Professor professor) {return professorService.create(professor);}

    @DeleteMapping("{id}")
    public Professor delete(@PathVariable Long id) {return professorService.delete(id);}

}
