package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.CourseEnrollment;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import com.scientiaunviversity.backend25.repositories.CourseEnrollmentRepository;
import com.scientiaunviversity.backend25.repositories.SubjectEnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectEnrollmentService {

    private final SubjectEnrollmentRepository subjectEnrollmentRepository;

    public SubjectEnrollmentService(SubjectEnrollmentRepository subjectEnrollmentRepository) {
        this.subjectEnrollmentRepository = subjectEnrollmentRepository;
    }

    public List<SubjectEnrollment> getAll() {return subjectEnrollmentRepository.findAll();}

    public SubjectEnrollment create(SubjectEnrollment subjectEnrollment) {
        return subjectEnrollmentRepository.save(subjectEnrollment);
    }
}
