package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.CourseEnrollment;
import com.scientiaunviversity.backend25.repositories.CourseEnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseEnrollmentService {

    private final CourseEnrollmentRepository courseEnrollmentRepository;

    public CourseEnrollmentService(CourseEnrollmentRepository courseEnrollmentRepository) {
        this.courseEnrollmentRepository = courseEnrollmentRepository;
    }

    public List<CourseEnrollment> getAll() {return courseEnrollmentRepository.findAll();}

    public CourseEnrollment getById(Long id) {return courseEnrollmentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Course enrollment not found."));}

    public CourseEnrollment create(CourseEnrollment courseEnrollment) {
        return courseEnrollmentRepository.save(courseEnrollment);
    }

    @Transactional
    public CourseEnrollment delete(Long id) {
        CourseEnrollment courseEnrollmentToDelete = getById(id);
        courseEnrollmentRepository.delete(courseEnrollmentToDelete);
        return courseEnrollmentToDelete;
    }
}
