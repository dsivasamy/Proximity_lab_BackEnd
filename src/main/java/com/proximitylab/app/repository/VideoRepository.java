package com.proximitylab.app.repository;

import com.proximitylab.app.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
    Page<Video> findAllByVideoTitleContainsAndTagsTag(String videoTitle, String tag, Pageable page);
}
