package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.ProfessorResponseDTO;
import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.mappers.ProfessorMapper;
import com.scientiaunviversity.backend25.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;

    public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    @GetMapping
    public List<ProfessorResponseDTO> getAll() {
        List<Professor> professorList = professorService.getAll();
        List<ProfessorResponseDTO> professorResponseDTOList = new ArrayList<>();
        for (Professor professor : professorList) {
            professorResponseDTOList.add(professorMapper.toResponse(professor));
        } return professorResponseDTOList;
    }

    @GetMapping("/{id}")
    public ProfessorResponseDTO getById(@PathVariable Long id) {
        return professorMapper.toResponse(professorService.getById(id));
    }

    @PostMapping
    public ProfessorResponseDTO create(@RequestBody Professor professor) {
        return professorMapper.toResponse(professorService.create(professor));
    }

    @DeleteMapping("/{id}")
    public ProfessorResponseDTO delete(@PathVariable Long id) {
        return professorMapper.toResponse(professorService.delete(id));
    }

}
