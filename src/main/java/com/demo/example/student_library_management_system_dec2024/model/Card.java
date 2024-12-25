package com.demo.example.student_library_management_system_dec2024.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@Data
public class Card {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_status",nullable = false)
    private String cardStatus;

    @Column(name = "create_date",nullable = false)
    @CreationTimestamp // it automatically adds time and date when card is created/added
    private Date createDate;

    @Column(name = "update_date",nullable = false)
    @UpdateTimestamp // it automatically updates time and date when card is updated
    private Date updateDate;

    @JsonBackReference
    @OneToOne
    @JoinColumn // it joins the primary key of student table as foreign key in card table
    private Student student;

    @JsonManagedReference
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Book> booksIssuedToCard = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transaction> transactionsIssuedToCard = new ArrayList<>();


    // mappedBy = @JsonManagedReference
    // @JoinColumn  = @JsonBackReference

}
