DROP TABLE IF EXISTS instructors;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS subjects;
DROP TABLE IF EXISTS tags;
DROP table IF EXISTS lessons;
DROP table IF EXISTS videos;
DROP table IF EXISTS students;
CREATE TABLE instructors
(
    ins_id     INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    age        int DEFAULT 0,
    gender     VARCHAR(250) NOT NULL,
    email      VARCHAR(250) NOT NULL,
    created_at TIMESTAMP
);
CREATE TABLE courses
(
    course_id   INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(250),
    description VARCHAR(250),
    created_date  TIMESTAMP,
    M_VIEWS     int,
    lesson_id   int,
    status      boolean
);

CREATE TABLE subjects
(
    sub_id       INT AUTO_INCREMENT PRIMARY KEY,
    sub_Desc     VARCHAR(250),
    created_date TIMESTAMP,
    last_updated TIMESTAMP,
    video_id     int,
    course_id    INT
);
CREATE TABLE lessons
(
    lesson_id INT AUTO_INCREMENT PRIMARY KEY,
    ins_id    INT,
    video_id  int,
    status    boolean,
    lesson_name VARCHAR(250)
);

CREATE TABLE videos
(
    video_id    INT AUTO_INCREMENT PRIMARY KEY,
    video_title VARCHAR(250),
    url         VARCHAR(250),
    total_views int,
    ins_id      int,
    status      boolean
);

CREATE TABLE tags
(
    tag_id   INT AUTO_INCREMENT PRIMARY KEY,
    tag_name VARCHAR(250),
    video_id int
);
CREATE TABLE students
(
    student_id   INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(250),
    LAST_NAME VARCHAR(250),
    address VARCHAR(250),
    sub_status boolean,
    course_id int

);

