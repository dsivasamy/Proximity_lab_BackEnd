package com.proximitylab.app.entity;

import com.proximitylab.app.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @Column(name = "ins_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "email")
    private String email;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = Video.class,
            cascade = {
                    CascadeType.ALL
            })
    @JoinColumn(name = "ins_id")
    private List<Video> video;

    public Instructor() {

    }

    public Instructor(long insId, int age, String firstName, String last_name, Timestamp createdAt) {
        this.insId = insId;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }
}
