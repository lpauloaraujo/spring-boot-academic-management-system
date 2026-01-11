package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.CourseResponseDTO;
import com.scientiaunviversity.backend25.domain.Course;
import com.scientiaunviversity.backend25.mappers.CourseMapper;
import com.scientiaunviversity.backend25.services.CourseService;
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

    @GetMapping("/{id}")
    public CourseResponseDTO getById (@PathVariable Long id) {
        return courseMapper.toResponse(courseService.getById(id));
    }

    @PostMapping
    public CourseResponseDTO create(@RequestBody Course course) {
        return courseMapper.toResponse(courseService.create(course));
    }

    @DeleteMapping("/{id}")
    public CourseResponseDTO delete(@PathVariable Long id) {return courseMapper.toResponse(courseService.delete(id));}

}
