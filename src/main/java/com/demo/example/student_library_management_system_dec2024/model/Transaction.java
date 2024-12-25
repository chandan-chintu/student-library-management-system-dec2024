package com.demo.example.student_library_management_system_dec2024.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.dao.DataAccessException;

import java.util.Date;


@Entity
@Table(name = "transaction")
@Data
public class Transaction {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "transaction_status")
    private String transactionStatus;
    @Column(name = "transaction_date")
    @CreationTimestamp
    private Date transactionDate;
    @Column(name = "due_date")
    private String dueDate;
    @Column
    private double fine;
    @Column(name = "issue_or_return")
    private String issueOrReturn;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;

}
