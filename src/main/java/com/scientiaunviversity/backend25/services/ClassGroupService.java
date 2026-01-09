package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.ClassGroup;
import com.scientiaunviversity.backend25.repositories.ClassGroupRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassGroupService {

    private final ClassGroupRepository classGroupRepository;

    public ClassGroupService(ClassGroupRepository classGroupRepository) {
        this.classGroupRepository = classGroupRepository;
    }

    public List<ClassGroup> getAll() {return classGroupRepository.findAll();}

    public ClassGroup getById(Long id) {return classGroupRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Class group not found."));}

    public ClassGroup create(ClassGroup classGroup) {return classGroupRepository.save(classGroup);}
}
