package com.proximitylab.app.repository;

import com.proximitylab.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}

