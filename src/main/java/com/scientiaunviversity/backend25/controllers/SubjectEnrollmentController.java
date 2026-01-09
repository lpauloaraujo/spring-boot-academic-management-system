package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import com.scientiaunviversity.backend25.services.SubjectEnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject_enrollments")
public class SubjectEnrollmentController {

    private final SubjectEnrollmentService subjectEnrollmentService;

    public SubjectEnrollmentController(SubjectEnrollmentService subjectEnrollmentService) {
        this.subjectEnrollmentService = subjectEnrollmentService;
    }

    @GetMapping
    public List<SubjectEnrollment> getAll() {return subjectEnrollmentService.getAll();}

    @GetMapping(params = {"studentId", "classGroupId"})
    public SubjectEnrollment getById(@RequestParam Long studentId, @RequestParam Long classGroupId) {
        return subjectEnrollmentService.getById(studentId, classGroupId);
    }

    @PostMapping
    public SubjectEnrollment create(@RequestBody SubjectEnrollment subjectEnrollment) {
        return subjectEnrollmentService.create(subjectEnrollment);
    }
}
