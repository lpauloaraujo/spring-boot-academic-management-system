package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.DTOs.request.ProfessorRequestDTO;
import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.mappers.ProfessorMapper;
import com.scientiaunviversity.backend25.repositories.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    public Professor getById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found."));
    }

    public Professor create(ProfessorRequestDTO professorRequestDTO) {
        return professorRepository.save(professorMapper.toEntity(professorRequestDTO));
    }

    @Transactional
    public Professor delete(Long id) {
        Professor professorToDelete = getById(id);
        professorRepository.delete(professorToDelete);
        return professorToDelete;
    }

    @Transactional
    public Professor update(Long id, ProfessorRequestDTO professorRequestDTO) {
        Professor professorToUpdate = getById(id);
        professorToUpdate.setFullName(professorRequestDTO.getFullName());
        professorToUpdate.setEmail(professorToUpdate.getEmail());
        professorToUpdate.setPassword(professorRequestDTO.getPassword());
        professorToUpdate.setCpf(professorRequestDTO.getCpf());
        professorToUpdate.setRegistrationNumber(professorRequestDTO.getRegistrationNumber());
        professorToUpdate.setAcademicDegree(professorRequestDTO.getAcademicDegree());
        professorToUpdate.setDepartment(professorRequestDTO.getDepartment());
        return professorToUpdate;
    }
}
