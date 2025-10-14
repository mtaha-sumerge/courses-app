package com.sumerge.jdbc;

import com.sumerge.jdbc.model.Course;
import com.sumerge.jdbc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

    private final CourseService courseService;

    @Autowired
    public JdbcApplication(CourseService courseService) {
        this.courseService = courseService;
    }

	public static void main(String[] args) {

        SpringApplication.run(JdbcApplication.class, args);

	}

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\nCreating a new course...");

        Course course = new Course(704, "Spring JDBC", "Learn Spring JDBC with Sumerge", 2);
        System.out.println(course.toString() + "\n");

        System.out.println("Courses before adding the new course: ");
        System.out.println(courseService.getAllCourses() + "\n");

        courseService.addCourse(course);

        System.out.println("\nCourses after adding the new course: ");
        System.out.println(courseService.getAllCourses() + "\n");

        System.out.println("Updating the course with id " + courseService.getAllCourses().getFirst().getId());
        course.setId(courseService.getAllCourses().getFirst().getId());
        course.setName("Angular");
        course.setDescription("Learn Angular with Sumerge");
        course.setCredit(3);
        courseService.updateCourse(course);

        System.out.println("\nCourses after updating the course: ");
        System.out.println(courseService.getAllCourses() + "\n");

        System.out.println("Deleting the course with id " + courseService.getAllCourses().getFirst().getId());
        courseService.deleteCourse(courseService.getAllCourses().getFirst().getId());

        System.out.println("\nCourses after deleting the course: ");
        System.out.println(courseService.getAllCourses() + "\n");

        System.out.println("Viewing the course with id " + courseService.getAllCourses().getFirst().getId());
        courseService.viewCourse(courseService.getAllCourses().getFirst().getId());

    }

}
