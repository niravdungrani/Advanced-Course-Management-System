package com.example.Advanced.Course.Management.System.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private String title;
    private int maxEnrollment;
    private String schedule;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prerequisite> prerequisites;
}
