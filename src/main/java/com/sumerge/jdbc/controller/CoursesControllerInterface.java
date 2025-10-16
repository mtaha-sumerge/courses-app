package com.sumerge.jdbc.controller;

import com.sumerge.jdbc.model.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CoursesControllerInterface {

    @PostMapping("/courses")
    ResponseEntity<Void> addCourse(@RequestBody Course course);

    @GetMapping("/courses")
    ResponseEntity<List<Course>> getAllCourses();

    @GetMapping("/courses/{id}")
    ResponseEntity<Course> getCourse(@PathVariable int id);

    @PutMapping("/courses")
    ResponseEntity<Void> updateCourse(@RequestBody Course course);

    @DeleteMapping("/courses/{id}")
    ResponseEntity<Void> deleteCourse(@PathVariable int id);
}
