package com.example.Advanced.Course.Management.System.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Prerequisite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private Course prerequisite;

}
