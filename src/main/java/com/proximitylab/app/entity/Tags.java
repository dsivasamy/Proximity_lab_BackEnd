package com.proximitylab.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
public class Tags {
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tag_name")
    private String tag;
    @Column(name = "video_id")
    private Long videoID;
}
