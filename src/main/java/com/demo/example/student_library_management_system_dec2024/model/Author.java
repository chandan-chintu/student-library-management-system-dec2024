package com.demo.example.student_library_management_system_dec2024.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String country;

    @Column
    private Double rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> bookByAuthor = new ArrayList<>();
}
