package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.DTOs.request.ClassGroupRequestDTO;
import com.scientiaunviversity.backend25.domain.ClassGroup;
import com.scientiaunviversity.backend25.domain.Subject;
import com.scientiaunviversity.backend25.repositories.ClassGroupRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassGroupService {

    private final ClassGroupRepository classGroupRepository;
    private final SubjectService subjectService;

    public ClassGroupService(ClassGroupRepository classGroupRepository, SubjectService subjectService) {
        this.classGroupRepository = classGroupRepository;
        this.subjectService = subjectService;
    }

    public List<ClassGroup> getAll() {return classGroupRepository.findAll();}

    public ClassGroup getById(Long id) {return classGroupRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Class group not found."));}

    @Transactional
    public ClassGroup create(ClassGroupRequestDTO classGroupRequestDTO) {
        Subject subject = subjectService.getById(classGroupRequestDTO.getSubjectId());

        ClassGroup classGroup = new ClassGroup();
        classGroup.setSubject(subject);
        classGroup.setCode(classGroupRequestDTO.getCode());
        classGroup.setSemester(classGroupRequestDTO.getSemester());
        classGroup.setMaxStudents(classGroupRequestDTO.getMaxStudents());
        classGroup.setStatus(classGroupRequestDTO.getStatus());

        classGroupRepository.save(classGroup);

        return classGroup;
    }

    @Transactional
    public ClassGroup delete(Long id) {
        ClassGroup classGroupToDelete = getById(id);
        classGroupRepository.delete(classGroupToDelete);
        return classGroupToDelete;
    }

    @Transactional
    public ClassGroup update(Long id, ClassGroupRequestDTO classGroupRequestDTO) {
        ClassGroup classGroupToUpdate = getById(id);
        Subject subject = subjectService.getById(classGroupRequestDTO.getSubjectId());
        classGroupToUpdate.setSubject(subject);
        classGroupToUpdate.setCode(classGroupRequestDTO.getCode());
        classGroupToUpdate.setSemester(classGroupRequestDTO.getSemester());
        classGroupToUpdate.setMaxStudents(classGroupRequestDTO.getMaxStudents());
        classGroupToUpdate.setStatus(classGroupRequestDTO.getStatus());
        return classGroupToUpdate;
    }
}
