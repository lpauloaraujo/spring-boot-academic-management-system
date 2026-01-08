package com.scientiaunviversity.backend25.repositories;

import com.scientiaunviversity.backend25.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
