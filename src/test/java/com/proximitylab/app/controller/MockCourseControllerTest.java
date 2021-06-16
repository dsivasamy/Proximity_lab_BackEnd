package com.proximitylab.app.controller;

import com.proximitylab.app.repository.CourseRepository;
import com.proximitylab.app.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@Slf4j
public class MockCourseControllerTest {
    @InjectMocks
    private  CourseController courseController;
    @Mock
    private CourseService courseService;
    @Mock
    private CourseRepository courseRepository;

}
