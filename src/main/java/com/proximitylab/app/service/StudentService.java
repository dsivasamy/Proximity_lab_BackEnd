package com.proximitylab.app.service;

import com.proximitylab.app.entity.Course;
import com.proximitylab.app.entity.Student;
import com.proximitylab.app.repository.CourseRepository;
import com.proximitylab.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Boolean addStudent(Student student) {
        Boolean courseFound=false;
        if (student.isSubcriptionStatus()){
            Optional<Course> course = courseRepository.findById(student.getCourseId());
            if(course.isPresent()){
                courseFound=true;
            }else {
                student.setSubcriptionStatus(courseFound);
            }
        }
        return studentRepository.save(student)!=null;
    }
    public Boolean updateStudent(Student student) {
        return addStudent(student);
    }
}
