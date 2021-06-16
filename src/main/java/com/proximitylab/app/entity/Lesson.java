package com.proximitylab.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql =
        "UPDATE lessons " +
                "SET status=false" +
                "WHERE id = ?")
@Where(clause = "status =true")
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private int lessonid;
    @Column(name = "ins_id")
    private Long insId;
    @Column(name = "lesson_name")
    private String lessonname;
    @Column(name = "video_id")
    private Long videoId;
    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = Course.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id")
    private List<Course> course;
    @Column(name = "status")
    private Boolean status;
}
