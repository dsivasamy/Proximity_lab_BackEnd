package com.proximitylab.app.service;

import com.proximitylab.app.entity.Lesson;
import com.proximitylab.app.model.ApiResponse;
import com.proximitylab.app.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public ApiResponse<Object> getAllLessons(String courseName, Pageable page) {
        Page<Lesson> course = lessonRepository.findByCourseCourseName(courseName, page);
        return ApiResponse.builder().numberOfItems(course.getTotalElements())
                .numberOfPages(course.getTotalPages()).data(course.getContent()).build();
    }


}
