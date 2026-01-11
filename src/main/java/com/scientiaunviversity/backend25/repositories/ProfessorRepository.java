package com.scientiaunviversity.backend25.repositories;

import com.scientiaunviversity.backend25.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
