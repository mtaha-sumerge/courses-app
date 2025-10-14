package com.sumerge.jdbc.repo;

import com.sumerge.jdbc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoursesRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoursesRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addCourse(Course course) {
        String query = "INSERT INTO course (id, name, description, credit) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(query, course.getId(), course.getName(), course.getDescription(), course.getCredit());
    }

    public int updateCourse(Course course) {
        String sql = "UPDATE Course SET name=?, description=?, credit=? WHERE id=?";
        return jdbcTemplate.update(sql, course.getName(), course.getDescription(), course.getCredit(), course.getId());
    }

    public Course getCourse(int id) {
        String query = "SELECT * FROM Course WHERE id=?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Course.class), id);
    }

    public int deleteCourse(int id) {
        String query = "DELETE FROM Course WHERE id=?";
        return jdbcTemplate.update(query, id);
    }

    public List<Course> findAll() {

        String query = "SELECT * FROM course";
        RowMapper<Course> rowMapper = new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setDescription(rs.getString("description"));
                course.setCredit(rs.getInt("credit"));
                return course;
            }
        };
        return jdbcTemplate.query(query, rowMapper);
    }

}
