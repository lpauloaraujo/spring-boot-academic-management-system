package com.scientiaunviversity.backend25.domain;

import com.scientiaunviversity.backend25.domain.enums.ClassGroupStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class ClassGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_group_id")
    private Long classGroupId;

    @OneToOne
    private Subject subject;

    @Column(name = "code")
    private String code;

    @Column(name = "semester")
    private String semester;

    @Column(name = "max_students")
    private Integer maxStudents;

    @Enumerated(EnumType.STRING)
    private ClassGroupStatus status;

    @OneToMany(mappedBy = "classGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubjectEnrollment> subjectEnrollments = new HashSet<>();

    @Column(name = "creation_date")
    private LocalDateTime createdAt;

    @Column(name = "update_date")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
