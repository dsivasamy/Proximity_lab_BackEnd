package com.proximitylab.app.service;

import com.proximitylab.app.entity.Course;
import com.proximitylab.app.helper.LoggingHelper;
import com.proximitylab.app.model.ApiResponse;
import com.proximitylab.app.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class CourseService {

    private CourseRepository courseRepository;
    private final LoggingHelper loggingHelper;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        this.loggingHelper = LoggingHelper.getInstance();
    }


    public ApiResponse<Object> getAllCourses(Pageable page) {
        loggingHelper.requestObject(log,"Inside the getAllCourses");
            Page<Course> course = courseRepository.findAll(page);
            return ApiResponse.builder().numberOfItems(course.getTotalElements())
                    .numberOfPages(course.getTotalPages()).data(course.getContent()).build();

    }

    public ApiResponse<Object> filterSubject(String name, Pageable pageable) {
        loggingHelper.requestObject(log,"Inside the filterSubject");
        Page<Course> course = courseRepository.findAllBySubjectSubjectDescContains(name, pageable);
        return ApiResponse.builder().numberOfItems(course.getTotalElements())
                .numberOfPages(course.getTotalPages()).data(course.getContent()).build();
    }

    public ApiResponse<Object> filterCourse(String name, Pageable pageable) {
        loggingHelper.requestObject(log,"Inside the filterCourse");
        Page<Course> course = courseRepository.findAllByCourseNameContains(name, pageable);
        return ApiResponse.builder().numberOfItems(course.getTotalElements())
                .numberOfPages(course.getTotalPages()).data(course.getContent()).build();
    }

    @Transactional
    public Optional<Course> getById(Long id) {
        loggingHelper.requestObject(log,"Inside the getById");
        Optional<Course> course = courseRepository.findById(id);
        Course updateMostView = course.orElseGet(Course::new);
        if (course.isPresent()) {
            int viewUpdate = updateMostView.getMostView();
            updateMostView.setMostView(++viewUpdate);
            courseRepository.save(updateMostView);
        }
        return course;
    }

    public void deleteCourse(Long id) {
        loggingHelper.requestObject(log,"Inside the deleteCourse");
        courseRepository.deleteById(id);
    }
}
