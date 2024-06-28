package com.example.Advanced.Course.Management.System.Service;

import com.example.Advanced.Course.Management.System.Exception.ResourceNotFoundException;
import com.example.Advanced.Course.Management.System.Model.Course;
import com.example.Advanced.Course.Management.System.Dto.StudentEnrollmentDTO;
import com.example.Advanced.Course.Management.System.Model.Enrollment;
import com.example.Advanced.Course.Management.System.Model.EnrollmentStatus;
import com.example.Advanced.Course.Management.System.Model.Prerequisite;
import com.example.Advanced.Course.Management.System.Repository.CourseRepository;
import com.example.Advanced.Course.Management.System.Repository.EnrollmentRepository;
import com.example.Advanced.Course.Management.System.Repository.PrerequisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PrerequisiteRepository prerequisiteRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Course saveCourse(Course course) {
        // Perform validation (e.g., schedule conflicts) and save course
        validateCourse(course);
        return courseRepository.save(course);
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourse(id);
        course.setCourseCode(courseDetails.getCourseCode());
        course.setTitle(courseDetails.getTitle());
        course.setMaxEnrollment(courseDetails.getMaxEnrollment());
        course.setSchedule(courseDetails.getSchedule());
        validateCourse(course);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Course course = getCourse(id);
        courseRepository.delete(course);
    }

    private void validateCourse(Course course) {
        // Implement validation logic for prerequisites and schedule conflicts
    }

    public List<Prerequisite> getPrerequisites(Long courseId) {
        return prerequisiteRepository.findByCourseId(courseId);
    }

    public List<StudentEnrollmentDTO> getEnrolledStudents(Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourseIdAndStatus(courseId, EnrollmentStatus.ACTIVE);
        return enrollments.stream()
                .map(enrollment -> new StudentEnrollmentDTO(enrollment.getStudent().getStudentNumber(), enrollment.getStudent().getName(), enrollment.getGrade(), enrollment.getStatus().name()))
                .collect(Collectors.toList());
    }
}
