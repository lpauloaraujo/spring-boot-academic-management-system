package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.request.SubjectEnrollmentRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.SubjectEnrollmentResponseDTO;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import com.scientiaunviversity.backend25.mappers.SubjectEnrollmentMapper;
import com.scientiaunviversity.backend25.services.SubjectEnrollmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subject_enrollments")
public class SubjectEnrollmentController {

    private final SubjectEnrollmentService subjectEnrollmentService;
    private final SubjectEnrollmentMapper subjectEnrollmentMapper;

    public SubjectEnrollmentController(SubjectEnrollmentService subjectEnrollmentService, SubjectEnrollmentMapper subjectEnrollmentMapper) {
        this.subjectEnrollmentService = subjectEnrollmentService;
        this.subjectEnrollmentMapper = subjectEnrollmentMapper;
    }

    @GetMapping
    public List<SubjectEnrollmentResponseDTO> getAll() {
        List<SubjectEnrollment> subjectEnrollmentList = subjectEnrollmentService.getAll();
        List<SubjectEnrollmentResponseDTO> subjectEnrollmentResponseDTOList = new ArrayList<>();
        for (SubjectEnrollment subjectEnrollment : subjectEnrollmentList) {
            subjectEnrollmentResponseDTOList.add(subjectEnrollmentMapper.toResponse(subjectEnrollment));
        }
        return subjectEnrollmentResponseDTOList;
    }

    @GetMapping(params = {"studentId", "classGroupId"})
    public SubjectEnrollmentResponseDTO getById(@RequestParam Long studentId, @RequestParam Long classGroupId) {
        return subjectEnrollmentMapper.toResponse(subjectEnrollmentService.getById(studentId, classGroupId));
    }

    @PostMapping
    public SubjectEnrollmentResponseDTO create(@RequestBody SubjectEnrollmentRequestDTO subjectEnrollmentRequestDTO) {
        return subjectEnrollmentMapper.toResponse(subjectEnrollmentService.create(subjectEnrollmentRequestDTO));
    }

    @DeleteMapping(params = {"studentId", "classGroupId"})
    public SubjectEnrollmentResponseDTO delete(@RequestParam Long studentId, @RequestParam Long classGroupId) {
        return subjectEnrollmentMapper.toResponse(subjectEnrollmentService.delete(studentId, classGroupId));
    }

    @PutMapping(params = {"studentId", "classGroupId"})
    public SubjectEnrollmentResponseDTO update(
            @RequestParam Long studentId,
            @RequestParam Long classGroupId,
            @RequestBody @Valid SubjectEnrollmentRequestDTO subjectEnrollmentRequestDTO
    ) {
        return subjectEnrollmentMapper.toResponse(subjectEnrollmentService.update(studentId,
                classGroupId,
                subjectEnrollmentRequestDTO)
        );
    }
}