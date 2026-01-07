package com.scientiaunviversity.backend25.repositories;

import com.scientiaunviversity.backend25.domain.EnrollmentId;
import com.scientiaunviversity.backend25.domain.SubjectEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectEnrollmentRepository extends JpaRepository<SubjectEnrollment, EnrollmentId> {
}
