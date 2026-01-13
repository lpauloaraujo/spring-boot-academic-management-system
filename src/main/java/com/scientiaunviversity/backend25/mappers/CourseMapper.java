package com.scientiaunviversity.backend25.mappers;

import com.scientiaunviversity.backend25.DTOs.request.CourseRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.CourseResponseDTO;
import com.scientiaunviversity.backend25.domain.Course;
import com.scientiaunviversity.backend25.domain.Subject;
import org.antlr.v4.runtime.misc.Array2DHashSet;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();
        course.setName(courseRequestDTO.getName());
        return course;
    }

    public CourseResponseDTO toResponse(Course course) {

        Set<Subject> courseSubjects = course.getSubjects();
        Set<String> courseSubjectsNames = new Array2DHashSet<>();
        for (Subject subject : courseSubjects) {
            courseSubjectsNames.add(subject.getName());
        }

        return new CourseResponseDTO(
                course.getCourseId(),
                course.getName(),
                courseSubjectsNames
        );
    }
}
