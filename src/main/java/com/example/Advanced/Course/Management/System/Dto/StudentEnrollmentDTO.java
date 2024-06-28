package com.example.Advanced.Course.Management.System.Dto;

public class StudentEnrollmentDTO {
    private String studentNumber;
    private String name;
    private String grade;
    private String status;

    // Constructor
    public StudentEnrollmentDTO(String studentNumber, String name, String grade, String status) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.grade = grade;
        this.status = status;
    }

    // Getters and setters
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
