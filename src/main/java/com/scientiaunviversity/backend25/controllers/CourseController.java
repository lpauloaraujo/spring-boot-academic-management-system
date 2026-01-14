package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.request.CourseRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.CourseResponseDTO;
import com.scientiaunviversity.backend25.domain.Course;
import com.scientiaunviversity.backend25.mappers.CourseMapper;
import com.scientiaunviversity.backend25.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @GetMapping
    public List<CourseResponseDTO> getAll () {
        List<Course> courseList = courseService.getAll();
        List<CourseResponseDTO> courseResponseDTOList = new ArrayList<>();
        for (Course course : courseList) {
            courseResponseDTOList.add(courseMapper.toResponse(course));
        } return courseResponseDTOList;
    }

    @GetMapping("/{courseId}")
    public CourseResponseDTO getById (@PathVariable Long courseId) {
        return courseMapper.toResponse(courseService.getById(courseId));
    }

    @PostMapping
    public CourseResponseDTO create(@RequestBody CourseRequestDTO courseRequestDTO) {
        return courseMapper.toResponse(courseService.create(courseRequestDTO));
    }

    @DeleteMapping("/{courseId}")
    public CourseResponseDTO delete(@PathVariable Long courseId) {return courseMapper.toResponse(courseService.delete(courseId));}

    @PutMapping("/{courseId}")
    public CourseResponseDTO update(@PathVariable Long courseId, @RequestBody @Valid CourseRequestDTO courseRequestDTO) {
        return courseMapper.toResponse(courseService.update(courseId, courseRequestDTO));
    }

}
