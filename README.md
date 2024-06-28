# Advanced Course Management System

## Overview
The Advanced Course Management System is a Spring Boot-based RESTful API designed to manage Courses, Students, and Enrollments. The system includes complex functionalities such as prerequisite validation, course scheduling conflicts, academic performance tracking, and dynamic enrollment rules.

## Features
- **Courses Management**: Create, update, and delete courses. Validate prerequisites, ensure no schedule conflicts, and manage enrollment limits.
- **Student Management**: Create, update, and delete students. Validate course loads, and calculate GPA based on grades and course credits.
- **Enrollment Management**: Enroll students in courses, ensure prerequisites are met, prevent schedule conflicts, and manage grade updates and course withdrawals.
- **Performance Tracking**: Track student GPA, total credits earned, and identify academic probation status.

## Endpoints
### Courses
- **GET /courses**: List all courses.
- **POST /courses**: Create a new course.
- **PUT /courses/{id}**: Update a course.
- **DELETE /courses/{id}**: Delete a course.
- **GET /courses/{id}**: Get course details with prerequisites and enrolled student count.

### Students
- **GET /students**: List all students.
- **POST /students**: Create a new student.
- **PUT /students/{id}**: Update a student.
- **DELETE /students/{id}**: Delete a student.
- **GET /students/{id}/summary**: Get academic summary including GPA.

### Enrollments
- **POST /enroll**: Enroll a student in a course.
- **PUT /enroll/{enrollmentId}/drop**: Drop/Withdraw a student from a course.
- **PUT /enroll/{enrollmentId}/grade**: Update grade for an enrollment.
- **GET /courses/{courseId}/students**: List all students enrolled in a course with grades and status.

## Setup Instructions

### Prerequisites
- Java 8 or higher
- Maven
- MySQL

### Database Setup
1. Install MySQL and create a database named `cms`.
2. Run the `schema.sql` file located in `src/main/resources` to create the necessary tables.

### Application Configuration
1. Update the `application.properties` file with your MySQL username and password.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/cms
    spring.datasource.username=<your-username>
    spring.datasource.password=<your-password>
    spring.jpa.hibernate.ddl-auto=update
    ```

### Building and Running the Application
1. Navigate to the root directory of the project.
2. Build the project using Maven:
    ```bash
    mvn clean install
    ```
3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### Testing the API with Postman
Use the following Postman collection to test the API endpoints:
- **Add a New Course**: POST `http://localhost:8080/courses`
- **Get All Courses**: GET `http://localhost:8080/courses`
- **Update a Course**: PUT `http://localhost:8080/courses/{id}`
- **Delete a Course**: DELETE `http://localhost:8080/courses/{id}`
- **Add a New Student**: POST `http://localhost:8080/students`
- **Get All Students**: GET `http://localhost:8080/students`
- **Update a Student**: PUT `http://localhost:8080/students/{id}`
- **Delete a Student**: DELETE `http://localhost:8080/students/{id}`
- **Enroll a Student in a Course**: POST `http://localhost:8080/enroll`
- **Drop a Student from a Course**: PUT `http://localhost:8080/enroll/{enrollmentId}/drop`
- **Update Grade for an Enrollment**: PUT `http://localhost:8080/enroll/{enrollmentId}/grade`
- **Get All Students Enrolled in a Course**: GET `http://localhost:8080/courses/{courseId}/students`
- **Get Student's Academic Summary**: GET `http://localhost:8080/students/{id}/summary`

## Contributing
1. Fork the repository.
2. Create a new feature branch.
3. Commit your changes.
4. Push the branch.
5. Create a new Pull Request.

## License
This project is licensed under the MIT License.
