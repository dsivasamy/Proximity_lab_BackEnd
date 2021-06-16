package com.proximitylab.app.controller;

import com.proximitylab.app.entity.Course;
import com.proximitylab.app.helper.LoggingHelper;
import com.proximitylab.app.model.ApiResponse;
import com.proximitylab.app.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {


    private final CourseService courseService;

    private final LoggingHelper loggingHelper;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
        this.loggingHelper = LoggingHelper.getInstance();
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Object> getAll(Pageable page) {
        loggingHelper.requestObject(log,page);
        return courseService.getAllCourses(page);
    }

    @GetMapping("/subject/filter")
    public ApiResponse<Object> subjectsFilter(@Valid @RequestParam("query") String query, Pageable pageable) {

        return courseService.filterSubject(query, pageable);
    }

    @GetMapping("/filter")
    public ApiResponse<Object> courseFilter(@Valid @RequestParam("query") String query, Pageable pageable) {
        return courseService.filterCourse(query, pageable);
    }

    @GetMapping(value = "/{id}")
    public Course getCourse(@Valid @PathVariable Long id) {
        Optional<Course> course = courseService.getById(id);
        Course courseObject = null;
        if (course.isPresent()) {
            courseObject = course.get();
        }
        return courseObject;
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return HttpStatus.NO_CONTENT;
    }

}
