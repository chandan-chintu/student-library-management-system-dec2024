package com.demo.example.student_library_management_system_dec2024.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private int pages;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column
    private String genre;

    @Column
    private boolean available;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Author author;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

    @JsonManagedReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

}
