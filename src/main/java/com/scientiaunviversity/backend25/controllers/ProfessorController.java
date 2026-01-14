package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.request.ProfessorRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.ProfessorResponseDTO;
import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.mappers.ProfessorMapper;
import com.scientiaunviversity.backend25.services.ProfessorService;
import jakarta.validation.Valid;
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

    @GetMapping("/{professorId}")
    public ProfessorResponseDTO getById(@PathVariable Long professorId) {
        return professorMapper.toResponse(professorService.getById(professorId));
    }

    @PostMapping
    public ProfessorResponseDTO create(@RequestBody @Valid ProfessorRequestDTO professorRequestDTO) {
        return professorMapper.toResponse(professorService.create(professorRequestDTO));
    }

    @DeleteMapping("/{professorId}")
    public ProfessorResponseDTO delete(@PathVariable Long professorId) {
        return professorMapper.toResponse(professorService.delete(professorId));
    }

    @PutMapping("/{professorId}")
    public ProfessorResponseDTO update(@PathVariable Long professorId, @RequestBody @Valid ProfessorRequestDTO professorRequestDTO) {
        return professorMapper.toResponse(professorService.update(professorId, professorRequestDTO));
    }

}
