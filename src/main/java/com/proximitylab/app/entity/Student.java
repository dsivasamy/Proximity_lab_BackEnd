package com.proximitylab.app.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@SQLDelete(sql =
        "UPDATE students " +
                "SET sub_status=false" +
                "WHERE id = ?")
@Where(clause = "sub_status =true")
@Table(name="students")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column(name="sub_status")
    private boolean subcriptionStatus;
    @Column(name = "course_id")
    private Long courseId;
}
