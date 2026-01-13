package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.DTOs.request.SubjectRequestDTO;
import com.scientiaunviversity.backend25.domain.Course;
import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.domain.Subject;
import com.scientiaunviversity.backend25.repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final CourseService courseService;
    private final ProfessorService professorService;

    public SubjectService(SubjectRepository subjectRepository, CourseService courseService, ProfessorService professorService) {
        this.subjectRepository = subjectRepository;
        this.courseService = courseService;
        this.professorService = professorService;
    }

    public List<Subject> getAll() {return subjectRepository.findAll();}

    public Subject getById(Long id) {return subjectRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Subject not found."));}

    public Subject create(SubjectRequestDTO subjectRequestDTO) {
        Course course = courseService.getById(subjectRequestDTO.getCourseId());
        Professor professor = professorService.getById(subjectRequestDTO.getProfessorId());
        Subject subject = new Subject();
        subject.setName(subjectRequestDTO.getName());
        subject.setCourse(course);
        subject.setProfessor(professor);
        return subjectRepository.save(subject);
    }

    @Transactional
    public Subject delete(Long id) {
        Subject subjectToDelete = getById(id);
        subjectRepository.delete(subjectToDelete);
        return subjectToDelete;
    }
}
