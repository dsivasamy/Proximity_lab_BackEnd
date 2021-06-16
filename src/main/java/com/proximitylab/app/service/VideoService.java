package com.proximitylab.app.service;

import com.proximitylab.app.entity.Video;
import com.proximitylab.app.model.ApiResponse;
import com.proximitylab.app.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public ApiResponse<Object> filterVideoTagandTitle(String videoTitle, String tag, Pageable pageable) {
        Page<Video> video = videoRepository.findAllByVideoTitleContainsAndTagsTag(videoTitle, tag, pageable);
        updateMostView(video, videoRepository);
        return ApiResponse.builder().numberOfItems(video.getTotalElements())
                .numberOfPages(video.getTotalPages()).data(video.getContent()).build();
    }

    public ApiResponse<Object> getActiveAllVideos(Pageable pageable) {
        Page<Video> video = videoRepository.findAll(pageable);
        updateMostView(video, videoRepository);
        return ApiResponse.builder().numberOfItems(video.getTotalElements())
                .numberOfPages(video.getTotalPages()).data(video.getContent()).build();
    }

    public static void updateMostView(Page<Video> video, VideoRepository videoRepository) {

        List<Video> vid = video.getContent();
        for (Video videos : vid) {
            Optional<Video> optionalVideovideo = videoRepository.findById(videos.getId());
            Video updateMostView = optionalVideovideo.orElseGet(Video::new);
            if (optionalVideovideo.isPresent()) {
                Long viewUpdate = updateMostView.getTotalviews();
                updateMostView.setTotalviews(++viewUpdate);
                videoRepository.save(updateMostView);
            }
        }
    }

}
