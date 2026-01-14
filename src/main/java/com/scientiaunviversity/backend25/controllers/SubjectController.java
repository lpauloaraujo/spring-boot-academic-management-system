package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.request.SubjectRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.SubjectResponseDTO;
import com.scientiaunviversity.backend25.domain.Subject;
import com.scientiaunviversity.backend25.mappers.SubjectMapper;
import com.scientiaunviversity.backend25.services.SubjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/{subjectId}")
    public SubjectResponseDTO getById(@PathVariable Long subjectId) {
        return subjectMapper.toResponse(subjectService.getById(subjectId));
    }

    @PostMapping
    public SubjectResponseDTO create(@RequestBody SubjectRequestDTO subjectRequestDTO) {
        return subjectMapper.toResponse(subjectService.create(subjectRequestDTO));
    }

    @DeleteMapping("/{subjectId}")
    public SubjectResponseDTO delete(@PathVariable Long subjectId) {
        return subjectMapper.toResponse(subjectService.delete(subjectId));
    }

    @PutMapping("/{subjectId}")
    public SubjectResponseDTO update(@PathVariable Long subjectId, @RequestBody @Valid SubjectRequestDTO subjectRequestDTO) {
        return subjectMapper.toResponse(subjectService.update(subjectId, subjectRequestDTO));
    }
}
