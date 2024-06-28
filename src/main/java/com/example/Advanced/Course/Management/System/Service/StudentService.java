package com.example.Advanced.Course.Management.System.Service;

import com.example.Advanced.Course.Management.System.Dto.CourseGradeDTO;
import com.example.Advanced.Course.Management.System.Dto.StudentSummaryDTO;
import com.example.Advanced.Course.Management.System.Exception.ResourceNotFoundException;
import com.example.Advanced.Course.Management.System.Model.Enrollment;
import com.example.Advanced.Course.Management.System.Model.Student;
import com.example.Advanced.Course.Management.System.Repository.EnrollmentRepository;
import com.example.Advanced.Course.Management.System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Student saveStudent(Student student) {
        // Perform validation and save student
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudent(id);
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setStudentNumber(studentDetails.getStudentNumber());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudent(id);
        studentRepository.delete(student);
    }

    public StudentSummaryDTO getStudentSummary(Long id) {
        Student student = getStudent(id);
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(id);
        double gpa = calculateGPA(enrollments);
        int totalCredits = enrollments.size(); // Assuming each course is 1 credit for simplicity
        List<CourseGradeDTO> courses = enrollments.stream()
                .map(enrollment -> new CourseGradeDTO(enrollment.getCourse().getCourseCode(), enrollment.getGrade()))
                .collect(Collectors.toList());
        return new StudentSummaryDTO(gpa, totalCredits, courses);
    }

    private double calculateGPA(List<Enrollment> enrollments) {
        // Implement GPA calculation logic
        return 0.0; // Placeholder
    }
}
