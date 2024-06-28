package com.example.Advanced.Course.Management.System.Controller;

import com.example.Advanced.Course.Management.System.Dto.EnrollmentRequestDTO;
import com.example.Advanced.Course.Management.System.Dto.StudentEnrollmentDTO;
import com.example.Advanced.Course.Management.System.Model.Enrollment;
import com.example.Advanced.Course.Management.System.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment enrollStudent(@RequestBody EnrollmentRequestDTO request) {
        return enrollmentService.enrollStudent(request.getStudentId(), request.getCourseId());
    }

    @PutMapping("/{id}/drop")
    public Enrollment dropEnrollment(@PathVariable Long id) {
        return enrollmentService.dropEnrollment(id);
    }

    @PutMapping("/{id}/grade")
    public Enrollment updateGrade(@PathVariable Long id, @RequestBody String grade) {
        return enrollmentService.updateGrade(id, grade);
    }

    @GetMapping("/courses/{courseId}/students")
    public List<StudentEnrollmentDTO> getStudentsInCourse(@PathVariable Long courseId) {
        return enrollmentService.getStudentsInCourse(courseId);
    }
}
