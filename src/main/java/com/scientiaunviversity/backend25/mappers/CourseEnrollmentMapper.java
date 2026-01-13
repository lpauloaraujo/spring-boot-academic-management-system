package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.response.CourseEnrollmentResponseDTO;
import com.scientiaunviversity.backend25.domain.CourseEnrollment;
import org.springframework.stereotype.Component;

@Component
public class CourseEnrollmentMapper {

    public CourseEnrollmentResponseDTO toResponse(CourseEnrollment courseEnrollment) {
        return new CourseEnrollmentResponseDTO(
                courseEnrollment.getId(),
                courseEnrollment.getEnrollmentCode(),
                courseEnrollment.getStudent().getFullName(),
                courseEnrollment.getCourse().getName(),
                courseEnrollment.getAdmissionDate(),
                courseEnrollment.getStatus()
        );
    }
}
