package com.example.Advanced.Course.Management.System.Repository;

import com.example.Advanced.Course.Management.System.Model.Prerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrerequisiteRepository extends JpaRepository<Prerequisite,Long> {
    List<Prerequisite> findByCourseId(Long courseId);

}
