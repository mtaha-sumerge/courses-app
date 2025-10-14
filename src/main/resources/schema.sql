CREATE TABLE Author (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL
);

CREATE TABLE Course (
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(100) NOT NULL,
    credit INT NOT NULL
);

CREATE TABLE CourseAuthor (
    author_id INT,
    course_id INT,
    PRIMARY KEY (author_id, course_id),
    FOREIGN KEY (author_id) REFERENCES Author(id),
    FOREIGN KEY (course_id) REFERENCES Course(id)
);

CREATE TABLE Assessment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(100) NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES Course(id)
);

CREATE TABLE Rating (
    id INT PRIMARY KEY AUTO_INCREMENT,
    number INT NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES Course(id)
);