package com.sumerge.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {

    private int id;
    private String name;
    private String email;
    private Date birthDate;

//    private List<Course> courses;
}
