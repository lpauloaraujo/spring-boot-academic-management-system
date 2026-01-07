package com.scientiaunviversity.backend25.repositories;

import com.scientiaunviversity.backend25.domain.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {
}
