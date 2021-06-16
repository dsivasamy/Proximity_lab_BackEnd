package com.proximitylab.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "subjects")
public class Subject {
    @Id
    @Column(name = "sub_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subId;
    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdAt;
    @Column(name = "last_updated")
    private Timestamp lastUpdateAt;
    @Column(name = "sub_Desc")
    private String subjectDesc;
    @Column(name = "video_id")
    private Long videoID;
    @Column(name = "course_id")
    private Long courseId;
    public Subject() {

    }
}
