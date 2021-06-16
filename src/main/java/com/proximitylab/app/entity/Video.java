package com.proximitylab.app.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SQLDelete(sql =
        "UPDATE lessons " +
                "SET status=false" +
                "WHERE id = ?")
@Where(clause = "status =true")
@Table(name = "videos")
public class Video {

    @Id
    @Column(name = "video_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "video_title")
    private String videoTitle;
    @Column(name = "url")
    private String url;
    @Column(name = "total_views")
    private Long totalviews;
    @Column(name = "ins_id")
    private Long insId;
    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = Lesson.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id")
    private List<Lesson> lesson;
    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = Tags.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id")
    private List<Tags> tags;
    @Column(name = "status")
    private Boolean status;

}
