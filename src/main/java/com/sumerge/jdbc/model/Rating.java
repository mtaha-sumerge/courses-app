package com.sumerge.jdbc.model;

public class Rating {

    private int id;
    private int number;

    private Course relatedCourse;

    public Rating() {}

    public Rating(int id, int number, Course course) {
        this.id = id;
        this.number = number;
        this.relatedCourse = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Course getCourse() {
        return relatedCourse;
    }

    public void setCourse(Course course) {
        this.relatedCourse = course;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", number=" + number +
                ", course=" + relatedCourse.getId() +
                '}';
    }
}
