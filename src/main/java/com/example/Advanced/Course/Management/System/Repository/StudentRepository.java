package com.example.Advanced.Course.Management.System.Repository;

import com.example.Advanced.Course.Management.System.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
