package com.sumerge.jdbc.service;

import com.sumerge.jdbc.model.Course;
import com.sumerge.jdbc.repo.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CoursesRepo coursesRepo;

    @Autowired
    public CourseService(CoursesRepo coursesRepo) {
        this.coursesRepo = coursesRepo;
    }

    public void addCourse(Course course) {
        int rowsAffected = this.coursesRepo.addCourse(course);
        if (rowsAffected == 1) System.out.println("Course " + course.getId() + " is added successfully");
    }

    public void updateCourse(Course course) {
        int rowsAffected = this.coursesRepo.updateCourse(course);
        if (rowsAffected == 1) System.out.println("Course " + course.getId() + " is updated successfully");
    }

    public void viewCourse(int id) {
        Course course = this.coursesRepo.getCourse(id);
        if (course == null) System.out.println("Course " + id + " not found");
        else System.out.println(course.toString());
    }

    public void deleteCourse(int id) {
        int rowsAffected = this.coursesRepo.deleteCourse(id);
        if (rowsAffected == 1) System.out.println("Course " + id + " is removed successfully");
    }

    public Course getCourseById(int id) {
        return this.coursesRepo.getCourse(id);
    }

    public List<Course> getAllCourses() {
        return this.coursesRepo.findAll();
    }
}
