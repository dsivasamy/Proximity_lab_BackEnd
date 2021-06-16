package com.proximitylab.app.service;

import com.proximitylab.app.entity.Course;
import com.proximitylab.app.entity.Instructor;
import com.proximitylab.app.entity.Video;
import com.proximitylab.app.repository.CourseRepository;
import com.proximitylab.app.repository.InstructorRepository;
import com.proximitylab.app.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final VideoRepository videoRepository;
    private final  CourseRepository courseRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, VideoRepository videoRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.videoRepository = videoRepository;
        this.courseRepository = courseRepository;
    }

    public boolean addUser(Instructor instructor) {
        return instructorRepository.save(instructor) != null;
    }

    public Optional<Instructor> getById(Long id) {
        return instructorRepository.findById(id);
    }

    public boolean updateUser(Instructor instructor) {
        return instructorRepository.save(instructor) != null;
    }

    public List<Instructor> findByName(String name) {
        return instructorRepository.findByFirstName(name);
    }

    public List<Instructor> getAllUsers() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    public void deleteUser(Long id) {
        instructorRepository.deleteById(id);
    }

    public List<Video> getMaxViewedVideos(){
       return videoRepository.findTop01ByOrderByTotalviewsDesc();
    }

    public List<Course> getMaxViewedCourses() {
        return courseRepository.findTop01ByOrderByMostView();
    }
}
