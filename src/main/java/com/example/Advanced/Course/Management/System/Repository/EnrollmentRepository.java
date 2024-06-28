package com.example.Advanced.Course.Management.System.Repository;

import com.example.Advanced.Course.Management.System.Model.Enrollment;
import com.example.Advanced.Course.Management.System.Model.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    List<Enrollment> findByStudentId(Long studentId);

    List<Enrollment> findByCourseIdAndStatus(Long courseId, EnrollmentStatus status);
}
