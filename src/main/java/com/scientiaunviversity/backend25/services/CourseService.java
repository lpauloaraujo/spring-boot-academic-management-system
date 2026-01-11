package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.Course;
import com.scientiaunviversity.backend25.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAll() {return courseRepository.findAll();}

    public Course getById(Long id) {return courseRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Course not found"));}

    public Course create(Course course) {return courseRepository.save(course);}

    @Transactional
    public Course delete(Long id) {
        Course courseToDelete = getById(id);
        courseRepository.delete(courseToDelete);
        return courseToDelete;
    }
}
