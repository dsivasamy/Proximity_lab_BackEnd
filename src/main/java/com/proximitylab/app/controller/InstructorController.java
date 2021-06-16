package com.proximitylab.app.controller;

import com.proximitylab.app.entity.Course;
import com.proximitylab.app.entity.Instructor;
import com.proximitylab.app.entity.Video;
import com.proximitylab.app.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public HttpStatus insertInstructor(@Valid @RequestBody Instructor instructor, @Valid @RequestParam Boolean Is_instructor) {
        HttpStatus httpStatus;
        if (Is_instructor) {
            httpStatus = instructorService.addUser(instructor) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        } else {
            httpStatus = HttpStatus.UNAUTHORIZED;
        }
        return httpStatus;
    }

    @GetMapping(value = "/{id}")
    public Instructor getUserById(@Valid @PathVariable Long id) {
        Optional<Instructor> instructor = instructorService.getById(id);
        Instructor instructorObject = null;
        if (instructor.isPresent()) {
            instructorObject = instructor.get();
        }
        return instructorObject;
    }

    @PutMapping
    public HttpStatus updateUser(@Valid @RequestBody Instructor instructor) {
        return instructorService.updateUser(instructor) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "/name/{name}")
    public List<Instructor> getUsersByName(@Valid @PathVariable String name) {
        return instructorService.findByName(name);
    }

    @GetMapping(value = "/all")
    public List<Instructor> getAll() {
        return instructorService.getAllUsers();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteUser(@Valid @PathVariable Long id, @PathVariable Boolean Is_instructor) {
        HttpStatus httpStatus = HttpStatus.NO_CONTENT;
        if (Is_instructor) {
            instructorService.deleteUser(id);
        } else {
            httpStatus = HttpStatus.UNAUTHORIZED;
        }
        return httpStatus;
    }

    @GetMapping(value = "/mostViwedVideos")
    public List<Video> getMaxvideosCourses() {
        return instructorService.getMaxViewedVideos();
    }
    @GetMapping(value = "/mostViwedCourses")
    public List<Course> getMaxviewsCourses() {
        return instructorService.getMaxViewedCourses();
    }
}
