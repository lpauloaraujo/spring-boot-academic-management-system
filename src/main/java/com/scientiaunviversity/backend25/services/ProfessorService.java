package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.repositories.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    public Professor getById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found."));
    }

    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    @Transactional
    public Professor delete(Long id) {
        Professor professorToDelete = getById(id);
        professorRepository.delete(professorToDelete);
        return professorToDelete;
    }
}
