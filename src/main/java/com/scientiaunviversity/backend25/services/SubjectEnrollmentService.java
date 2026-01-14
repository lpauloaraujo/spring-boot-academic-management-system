package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.DTOs.request.SubjectEnrollmentRequestDTO;
import com.scientiaunviversity.backend25.domain.ClassGroup;
import com.scientiaunviversity.backend25.domain.EnrollmentId;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import com.scientiaunviversity.backend25.repositories.SubjectEnrollmentRepository;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectEnrollmentService {

    private final SubjectEnrollmentRepository subjectEnrollmentRepository;
    private final StudentService studentService;
    private final ClassGroupService classGroupService;

    public SubjectEnrollmentService(SubjectEnrollmentRepository subjectEnrollmentRepository, StudentService studentService, ClassGroupService classGroupService) {
        this.subjectEnrollmentRepository = subjectEnrollmentRepository;
        this.studentService = studentService;
        this.classGroupService = classGroupService;
    }

    public List<SubjectEnrollment> getAll() {return subjectEnrollmentRepository.findAll();}

    public SubjectEnrollment getById(Long studentId, Long classGroupId) {
        EnrollmentId enrollmentId = new EnrollmentId();
        enrollmentId.setStudentId(studentId);
        enrollmentId.setClassGroupId(classGroupId);
        return subjectEnrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EntityNotFoundException("Subject enrollment not found."));
    }

    @Transactional
    public SubjectEnrollment create(SubjectEnrollmentRequestDTO subjectEnrollmentRequestDTO) {
        Student student = studentService.getById(subjectEnrollmentRequestDTO.getStudentId());
        ClassGroup classGroup = classGroupService.getById(subjectEnrollmentRequestDTO.getClassGroupId());

       SubjectEnrollment subjectEnrollment = new SubjectEnrollment();

       subjectEnrollment.setEnrollmentCode(subjectEnrollmentRequestDTO.getEnrollmentCode());
       subjectEnrollment.setStudent(student);
       subjectEnrollment.setClassGroup(classGroup);
       subjectEnrollment.setEnrollmentDate(subjectEnrollmentRequestDTO.getEnrollmentDate());
       subjectEnrollment.setStatus(subjectEnrollmentRequestDTO.getEnrollmentStatus());
       subjectEnrollment.setGrade(subjectEnrollmentRequestDTO.getGrade());

       subjectEnrollmentRepository.save(subjectEnrollment);

       return subjectEnrollment;
    }

    public SubjectEnrollment delete(Long studentId, Long classGroupId) {
        SubjectEnrollment subjectEnrollmentToDelete = getById(studentId, classGroupId);
        subjectEnrollmentRepository.delete(subjectEnrollmentToDelete);
        return subjectEnrollmentToDelete;
    }

    @Transactional
    public SubjectEnrollment update(Long studentId, Long classGroupId, SubjectEnrollmentRequestDTO subjectEnrollmentRequestDTO) {
        Student student = studentService.getById(studentId);
        ClassGroup classGroup = classGroupService.getById(classGroupId);

        SubjectEnrollment subjectEnrollmentToUpdate = getById(studentId, classGroupId);

        subjectEnrollmentToUpdate.setEnrollmentCode(subjectEnrollmentRequestDTO.getEnrollmentCode());
        subjectEnrollmentToUpdate.setStudent(student);
        subjectEnrollmentToUpdate.setClassGroup(classGroup);

        subjectEnrollmentToUpdate.setEnrollmentDate(subjectEnrollmentRequestDTO.getEnrollmentDate());
        subjectEnrollmentToUpdate.setStatus(subjectEnrollmentRequestDTO.getEnrollmentStatus());
        subjectEnrollmentToUpdate.setGrade(subjectEnrollmentRequestDTO.getGrade());

        subjectEnrollmentRepository.save(subjectEnrollmentToUpdate);

        return subjectEnrollmentToUpdate;
    }
}
