package com.sumerge.jdbc.controller;

import com.sumerge.jdbc.model.Course;
import com.sumerge.jdbc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {

    private final CourseService courseService;

    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/courses")
    public ResponseEntity<Void> addCourse(@RequestBody Course course) {
        this.courseService.addCourse(course);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(this.courseService.getAllCourses());
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id) {
        return ResponseEntity.ok(this.courseService.getCourseById(id));
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable int id, @RequestBody Course course) {
        this.courseService.updateCourse(course);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        this.courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

}
