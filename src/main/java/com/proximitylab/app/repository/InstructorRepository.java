package com.proximitylab.app.repository;

import com.proximitylab.app.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    List<Instructor> findByFirstName(String name);
}
