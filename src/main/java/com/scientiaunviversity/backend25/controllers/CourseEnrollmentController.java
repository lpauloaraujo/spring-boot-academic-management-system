package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.request.CourseEnrollmentRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.CourseEnrollmentResponseDTO;
import com.scientiaunviversity.backend25.domain.CourseEnrollment;
import com.scientiaunviversity.backend25.mappers.CourseEnrollmentMapper;
import com.scientiaunviversity.backend25.services.CourseEnrollmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("course_enrollments")
public class CourseEnrollmentController {

    private final CourseEnrollmentService courseEnrollmentService;
    private final CourseEnrollmentMapper courseEnrollmentMapper;

    public CourseEnrollmentController(
            CourseEnrollmentService courseEnrollmentService,
            CourseEnrollmentMapper courseEnrollmentMapper) {
        this.courseEnrollmentService = courseEnrollmentService;
        this.courseEnrollmentMapper = courseEnrollmentMapper;
    }

    @GetMapping
    public List<CourseEnrollmentResponseDTO> getAll() {
         List<CourseEnrollment> courseEnrollmentList = courseEnrollmentService.getAll();
         List<CourseEnrollmentResponseDTO> courseEnrollmentResponseDTOList = new ArrayList<>();
         for (CourseEnrollment courseEnrollment : courseEnrollmentList) {
             courseEnrollmentResponseDTOList.add(courseEnrollmentMapper.toResponse(courseEnrollment));
         } return courseEnrollmentResponseDTOList;
    }

    @GetMapping("/{id}")
    public CourseEnrollmentResponseDTO getById(@PathVariable Long id) {
        return courseEnrollmentMapper.toResponse(courseEnrollmentService.getById(id));
    }

    @PostMapping
    public CourseEnrollmentResponseDTO create(@RequestBody @Valid CourseEnrollmentRequestDTO courseEnrollmentRequestDTO)
    {return courseEnrollmentMapper.toResponse(courseEnrollmentService.create(courseEnrollmentRequestDTO));}

    @DeleteMapping("/{id}")
    public CourseEnrollmentResponseDTO delete(@PathVariable Long id) {
        return courseEnrollmentMapper.toResponse(courseEnrollmentService.delete(id));
    }

}
