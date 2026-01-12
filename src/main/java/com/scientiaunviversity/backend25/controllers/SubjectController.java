package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.SubjectResponseDTO;
import com.scientiaunviversity.backend25.domain.Subject;
import com.scientiaunviversity.backend25.mappers.SubjectMapper;
import com.scientiaunviversity.backend25.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    public SubjectController(SubjectService subjectService, SubjectMapper subjectMapper) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
    }

    @GetMapping
    public List<SubjectResponseDTO> getAll() {
        List<Subject> subjectList = subjectService.getAll();
        List<SubjectResponseDTO> subjectResponseDTOSList = new ArrayList<>();
        for (Subject subject : subjectList) {
            subjectResponseDTOSList.add(subjectMapper.toResponse(subject));
        } return subjectResponseDTOSList;
    }

    @GetMapping("/{id}")
    public SubjectResponseDTO getById(@PathVariable Long id) {
        return subjectMapper.toResponse(subjectService.getById(id));
    }

    @PostMapping
    public SubjectResponseDTO create(@RequestBody Subject subject) {
        return subjectMapper.toResponse(subjectService.create(subject));
    }

    @DeleteMapping("/{id}")
    public SubjectResponseDTO delete(@PathVariable Long id) {
        return subjectMapper.toResponse(subjectService.delete(id));
    }
}
