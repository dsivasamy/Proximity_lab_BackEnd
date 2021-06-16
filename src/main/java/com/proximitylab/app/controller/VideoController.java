package com.proximitylab.app.controller;

import com.proximitylab.app.model.ApiResponse;
import com.proximitylab.app.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;
@Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }


    @GetMapping(value = "/video/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Object> getAll(@Valid @RequestParam("videoTag") String videoTitle, @RequestParam("tagName") String tagName, Pageable pageable) {
        return videoService.filterVideoTagandTitle(videoTitle,tagName,pageable);
    }
    @GetMapping(value = "/activeVideos/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Object> getAll(Pageable pageable) {
        return videoService.getActiveAllVideos(pageable);
    }
   /* @GetMapping(value = "/activeVideos/SelectedLesson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Object> getAll(@Valid @RequestParam("videoTag") String videoTag,Pageable pageable) {
        return videoService.getActiveVideos(pageable);
    }*/
}
