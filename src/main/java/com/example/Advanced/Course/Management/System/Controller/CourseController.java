package com.example.Advanced.Course.Management.System.Controller;

import com.example.Advanced.Course.Management.System.Model.Course;
import com.example.Advanced.Course.Management.System.Dto.StudentEnrollmentDTO;
import com.example.Advanced.Course.Management.System.Model.Prerequisite;
import com.example.Advanced.Course.Management.System.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/prerequisites")
    public List<Prerequisite> getPrerequisites(@PathVariable Long id) {
        return courseService.getPrerequisites(id);
    }

    @GetMapping("/{id}/students")
    public List<StudentEnrollmentDTO> getEnrolledStudents(@PathVariable Long id) {
        return courseService.getEnrolledStudents(id);
    }
}
