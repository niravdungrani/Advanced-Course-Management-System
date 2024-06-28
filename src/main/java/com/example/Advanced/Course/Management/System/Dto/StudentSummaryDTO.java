package com.example.Advanced.Course.Management.System.Dto;

import java.util.List;

public class StudentSummaryDTO {
    private double gpa;
    private int totalCredits;
    private List<CourseGradeDTO> courses;

    public StudentSummaryDTO() {
    }

    public StudentSummaryDTO(double gpa, int totalCredits, List<CourseGradeDTO> courses) {
        this.gpa = gpa;
        this.totalCredits = totalCredits;
        this.courses = courses;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<CourseGradeDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseGradeDTO> courses) {
        this.courses = courses;
    }
}
