package com.example.Advanced.Course.Management.System.Service;

import com.example.Advanced.Course.Management.System.Exception.ResourceNotFoundException;
import com.example.Advanced.Course.Management.System.Model.Course;
import com.example.Advanced.Course.Management.System.Dto.StudentEnrollmentDTO;
import com.example.Advanced.Course.Management.System.Model.Enrollment;
import com.example.Advanced.Course.Management.System.Model.EnrollmentStatus;
import com.example.Advanced.Course.Management.System.Model.Student;
import com.example.Advanced.Course.Management.System.Repository.CourseRepository;
import com.example.Advanced.Course.Management.System.Repository.EnrollmentRepository;
import com.example.Advanced.Course.Management.System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        // Perform prerequisite and schedule conflict checks
        validateEnrollment(student, course);

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setStatus(EnrollmentStatus.ACTIVE);
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment dropEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        enrollment.setStatus(EnrollmentStatus.DROPPED);
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateGrade(Long id, String grade) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        enrollment.setGrade(grade);
        return enrollmentRepository.save(enrollment);
    }

    public List<StudentEnrollmentDTO> getStudentsInCourse(Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourseIdAndStatus(courseId, EnrollmentStatus.ACTIVE);
        return enrollments.stream()
                .map(enrollment -> new StudentEnrollmentDTO(enrollment.getStudent().getStudentNumber(), enrollment.getStudent().getName(), enrollment.getGrade(), enrollment.getStatus().name()))
                .collect(Collectors.toList());
    }

    private void validateEnrollment(Student student, Course course) {
        // Implement prerequisite and schedule conflict checks
    }

}
