package com.scientiaunviversity.backend25.repositories;

import com.scientiaunviversity.backend25.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
