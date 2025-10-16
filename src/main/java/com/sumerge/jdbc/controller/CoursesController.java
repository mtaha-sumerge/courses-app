package com.sumerge.jdbc.controller;

import com.sumerge.jdbc.model.Course;
import com.sumerge.jdbc.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController implements CoursesControllerInterface{

    private final CourseService courseService;

    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public ResponseEntity<Void> addCourse(@RequestBody Course course) {
        try {
            this.courseService.addCourse(course);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @Override
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(this.courseService.getAllCourses());
    }

    @Override
    public ResponseEntity<Course> getCourse(@PathVariable int id) {
        try {
            Course course = this.courseService.getCourseById(id);
            return ResponseEntity.ok(course);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> updateCourse(@RequestBody Course course) {
        try {
            Course tempCourse = this.courseService.getCourseById(course.getId());
            tempCourse.setName(course.getName());
            tempCourse.setDescription(course.getDescription());
            tempCourse.setCredit(course.getCredit());
            this.courseService.updateCourse(tempCourse);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        try {
            this.courseService.deleteCourse(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}
