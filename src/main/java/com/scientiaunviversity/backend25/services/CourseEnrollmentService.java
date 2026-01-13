package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.DTOs.request.CourseEnrollmentRequestDTO;
import com.scientiaunviversity.backend25.domain.Course;
import com.scientiaunviversity.backend25.domain.CourseEnrollment;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.domain.enums.CourseEnrollmentStatus;
import com.scientiaunviversity.backend25.repositories.CourseEnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseEnrollmentService {

    private final CourseEnrollmentRepository courseEnrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public CourseEnrollmentService(CourseEnrollmentRepository courseEnrollmentRepository, StudentService studentService, CourseService courseService) {
        this.courseEnrollmentRepository = courseEnrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public List<CourseEnrollment> getAll() {
        return courseEnrollmentRepository.findAll();
    }

    public CourseEnrollment getById(Long id) {
        return courseEnrollmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course enrollment not found."));
    }

    @Transactional
    public CourseEnrollment create(CourseEnrollmentRequestDTO courseEnrollmentRequestDTO) {

        Student student = studentService.getById(courseEnrollmentRequestDTO.getStudentId());
        Course course = courseService.getById(courseEnrollmentRequestDTO.getCourseId());

        CourseEnrollment courseEnrollment = new CourseEnrollment();
        courseEnrollment.setCourse(course);
        courseEnrollment.setEnrollmentCode(courseEnrollmentRequestDTO.getEnrollmentCode());
        courseEnrollment.setAdmissionDate(LocalDate.now());
        courseEnrollment.setStatus(CourseEnrollmentStatus.ACTIVE);

        student.addCourseEnrollment(courseEnrollment);

        return courseEnrollmentRepository.save(courseEnrollment);
    }

    @Transactional
    public CourseEnrollment delete(Long id) {
        CourseEnrollment courseEnrollmentToDelete = getById(id);
        courseEnrollmentRepository.delete(courseEnrollmentToDelete);
        return courseEnrollmentToDelete;
    }
}
