package com.demo.example.student_library_management_system_dec2024.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data // it generates getter and setter
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String dob;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = false)
    private String dept;

    @JsonManagedReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;


}
