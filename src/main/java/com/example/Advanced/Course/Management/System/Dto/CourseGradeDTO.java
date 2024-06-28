package com.example.Advanced.Course.Management.System.Dto;

public class CourseGradeDTO {
    private String courseCode;
    private String grade;

    // Constructor
    public CourseGradeDTO(String courseCode, String grade) {
        this.courseCode = courseCode;
        this.grade = grade;
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
