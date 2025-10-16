package com.sumerge.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {

    private int id;
    private String name;
    private String description;
    private int credit;

//    private List<Author> authors;

}
