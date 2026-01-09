package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.EnrollmentId;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
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

    public SubjectEnrollment getById(Long studentId, Long classGroupId) {
        EnrollmentId enrollmentId = new EnrollmentId();
        enrollmentId.setStudentId(studentId);
        enrollmentId.setClassGroupId(classGroupId);
        return subjectEnrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EntityNotFoundException("Subject enrollment not found."));
    }

    public SubjectEnrollment create(SubjectEnrollment subjectEnrollment) {
        return subjectEnrollmentRepository.save(subjectEnrollment);
    }
}
