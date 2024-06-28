package com.example.Advanced.Course.Management.System.Repository;

import com.example.Advanced.Course.Management.System.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
