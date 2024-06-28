package com.example.Advanced.Course.Management.System.Dto;

public class EnrollmentRequestDTO {
    private Long studentId;
    private Long courseId;

    // Getters and setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;

    }
}
