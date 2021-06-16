package com.proximitylab.app.repository;

import com.proximitylab.app.entity.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

    Page<Lesson> findByCourseCourseName(String name, Pageable page);
}
