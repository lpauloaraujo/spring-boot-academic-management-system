package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.domain.Course;
import com.scientiaunviversity.backend25.services.CourseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAll () {return courseService.getAll();}

    @GetMapping("/{id}")
    public Course getById (@PathVariable Long id) {return courseService.getById(id);}

    @PostMapping
    public Course create(@RequestBody Course course) {return courseService.create(course);}

    @DeleteMapping("/{id}")
    public Course delete(@PathVariable Long id) {return courseService.delete(id);}

}
