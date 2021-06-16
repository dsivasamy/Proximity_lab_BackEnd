package com.proximitylab.app.controller;

import com.proximitylab.app.model.ApiResponse;
import com.proximitylab.app.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LessonController {
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping(value = "/selectedCourses/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Object> getAll(@Valid @RequestParam("query") String query, Pageable pageable) {
        return lessonService.getAllLessons(query, pageable);
    }

}
