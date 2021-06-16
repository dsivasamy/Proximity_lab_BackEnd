package com.proximitylab.app.controller;

import com.proximitylab.app.entity.Student;
import com.proximitylab.app.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public HttpStatus createStudentProfile(@RequestBody Student student,@Valid @RequestParam Boolean Is_instructor){
        HttpStatus httpStatus;
        if (!Is_instructor) {
            httpStatus=studentService.addStudent(student) ? HttpStatus.CREATED :HttpStatus.BAD_REQUEST ;
        }else{
            httpStatus= HttpStatus.UNAUTHORIZED;
        }
        return httpStatus;
    }
    @PutMapping
    public HttpStatus updateStudentProfile(@RequestBody Student student,@Valid @RequestParam Boolean Is_instructor){
        HttpStatus httpStatus;
        if (!Is_instructor) {
            httpStatus=studentService.updateStudent(student) ? HttpStatus.ACCEPTED :HttpStatus.BAD_REQUEST ;
        }else{
            httpStatus=HttpStatus.UNAUTHORIZED;
        }
        return httpStatus;
    }
}
