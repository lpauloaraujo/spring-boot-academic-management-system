package com.scientiaunviversity.backend25.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EnrollmentId implements Serializable {
    private Long studentId;
    private Long classGroupId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnrollmentId that)) return false;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(classGroupId, that.classGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classGroupId);
    }
}
