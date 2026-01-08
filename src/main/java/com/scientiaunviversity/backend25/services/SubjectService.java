package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.Subject;
import com.scientiaunviversity.backend25.repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAll() {return subjectRepository.findAll();}

    public Subject getById(Long id) {return subjectRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Subject not found."));}

    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }
}
