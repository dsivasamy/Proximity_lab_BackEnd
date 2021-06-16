package com.proximitylab.app.controller;

import com.proximitylab.app.entity.Instructor;
import com.proximitylab.app.repository.InstructorRepository;
import com.proximitylab.app.service.InstructorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class MockitoInstructorControllerTest {

    @InjectMocks
    private InstructorController instructorController;
    @Mock
    private InstructorRepository instructorRepository;
    @Mock
    private InstructorService service;
    List<Instructor> list = new ArrayList<>();

    @BeforeEach
    public void setup() {
        list.add(new Instructor(121L, 28, "John", "math", new Timestamp(System.currentTimeMillis())));
        list.add(new Instructor(124L, 32, "Virat", "Kohil", new Timestamp(System.currentTimeMillis())));
        list.add(new Instructor(129L, 34, "Sachin", "Tend", new Timestamp(System.currentTimeMillis())));
    }

    @BeforeEach
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetInstructorById() {
        Instructor i = new Instructor();
        i.setInsId(121L);
        when(service.getById(121L)).thenReturn(Optional.of(i));
        Instructor instructor = instructorController.getUserById(121L);
        verify(service).getById(121L);
        Assertions.assertEquals(121L, instructor.getInsId().longValue());
    }

    @Test
    public void testGetAll() {
        when(service.getAllUsers()).thenReturn(list);
        List<Instructor> instructors = instructorController.getAll();
        verify(service).getAllUsers();
        Assertions.assertEquals(list, instructors);
    }

}
