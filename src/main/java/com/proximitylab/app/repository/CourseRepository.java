package com.proximitylab.app.repository;

import com.proximitylab.app.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAllByCourseNameContains(String firstName, Pageable pageable);

    Page<Course> findAllBySubjectSubjectDescContains(String firstName, Pageable pageable);

    List<Course> findTop01ByOrderByMostView();


}
