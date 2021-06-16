# Proximity Challenge Assigment

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
This application provides only a REST API. There is no UI. ANy front end application can be consumed this rest API.
Technologies used ,
- Java11
- Spring Boot 2.5
- Spring JPA
- H2 dataBase(Embedded and server modes; in-memory databases)
- Maven
- Lombok
- Mockito
- Swagger
## Features
- Developing API Endpoints for Pagination, Sorting and Filtering.
- Developing API Endpoints Use Pageable With JpaRepository.
## User Stories
As logged in instructor, I can create, view, edit, delete Tags.
As logged in instructor, I can create, view, edit, delete Subjects.
As logged in instructor, I can create, view, edit, delete Courses.
As logged in instructor, I can create, view, edit, delete Lesson.
As logged in instructor, I can create, view, edit, delete Videos.
As logged in instructor, I can view analytics - most viewed Courses and Videos.
As a logged in student, I can view all active Courses. I can filter Courses by Subject.
As a logged in student, I can view all active Lessons for a selected Course.
As a logged in student, I can view all active Videos for a selected Lesson. Videos Can be filtered by Video title and Tag names.
As a logged in student, I can view the selected Video details.
As a logged in student, I can subscribe, unsubsribe to various Courses.

# Swagger EndPoints
- Screenshots of Endpoints also avalible in  project Folder
- Entity relationship Screenshot also attached in project folder
- Swagger endpoints http://localhost:8080//swagger-ui-custom.html
- H2 database http://localhost:8080/h2-console

# Things to Improve in future.
- Containerization Application.
- Implementing  CI/CD pipeline using Jenkins and depoly in AWS cloud(ECS)
- Implementing metrics for application
- For testing puprose I used H2 embedded database but in enterprise level we need to go for MongoDB/Dynamo DB/ Postgres /ElasticSearch based on requirements. 
