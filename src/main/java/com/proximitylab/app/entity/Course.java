package com.proximitylab.app.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@SQLDelete(sql =
        "UPDATE courses " +
                "SET status=false" +
                "WHERE id = ?")
@Where(clause = "status =true")
@Table(name = "courses")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @NotNull(message = "Created Date is mandatory")
    @Column(name = "created_date")
    private Timestamp createdAt;
    @NotBlank(message = "course_name is mandatory")
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "description")
    private String description;
    @Column(name = "m_views")
    private Integer mostView;
    @Column(name = "lesson_id")
    private Long studentId;
    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = Subject.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Subject> subject;
    @Column(name = "status")
    private Boolean status;


}
