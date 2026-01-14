package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.DTOs.request.CourseRequestDTO;
import com.scientiaunviversity.backend25.domain.Course;
import com.scientiaunviversity.backend25.mappers.CourseMapper;
import com.scientiaunviversity.backend25.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper couseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper couseMapper) {
        this.courseRepository = courseRepository;
        this.couseMapper = couseMapper;
    }

    public List<Course> getAll() {return courseRepository.findAll();}

    public Course getById(Long id) {return courseRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Course not found"));}

    public Course create(CourseRequestDTO courseRequestDTO) {
        return courseRepository.save(couseMapper.toEntity(courseRequestDTO));
    }

    @Transactional
    public Course delete(Long id) {
        Course courseToDelete = getById(id);
        courseRepository.delete(courseToDelete);
        return courseToDelete;
    }

    @Transactional
    public Course update(Long id, CourseRequestDTO courseRequestDTO) {
        Course courseToUpdate = getById(id);
        courseToUpdate.setName(courseToUpdate.getName());
        return courseToUpdate;
    }
}
