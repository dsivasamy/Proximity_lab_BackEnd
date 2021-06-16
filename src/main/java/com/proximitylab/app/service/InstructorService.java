package com.proximitylab.app.service;

import com.proximitylab.app.entity.Instructor;
import com.proximitylab.app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
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
}
