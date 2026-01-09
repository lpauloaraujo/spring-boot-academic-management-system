package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.domain.CourseEnrollment;
import com.scientiaunviversity.backend25.services.CourseEnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course_enrollments")
public class CourseEnrollmentController {

    private final CourseEnrollmentService courseEnrollmentService;

    public CourseEnrollmentController(CourseEnrollmentService courseEnrollmentService) {
        this.courseEnrollmentService = courseEnrollmentService;
    }

    @GetMapping
    public List<CourseEnrollment> getAll() {return courseEnrollmentService.getAll();}

    @GetMapping("/{id}")
    public CourseEnrollment getById(@PathVariable Long id) {return courseEnrollmentService.getById(id);}

    @PostMapping
    public CourseEnrollment create(@RequestBody CourseEnrollment courseEnrollment) {
        return courseEnrollmentService.create(courseEnrollment);
    }
}
