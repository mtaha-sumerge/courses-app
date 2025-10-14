package com.sumerge.jdbc.model;

public class Assessment {

    private int id;
    private String content;

    private Course relatedCourse;

    public Assessment() {}

    public Assessment(int id, String content, Course relatedCourse) {
        this.id = id;
        this.content = content;
        this.relatedCourse = relatedCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Course getRelatedCourse() {
        return relatedCourse;
    }

    public void setRelatedCourse(Course relatedCourse) {
        this.relatedCourse = relatedCourse;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", relatedCourse=" + relatedCourse.getId() +
                '}';
    }
}
