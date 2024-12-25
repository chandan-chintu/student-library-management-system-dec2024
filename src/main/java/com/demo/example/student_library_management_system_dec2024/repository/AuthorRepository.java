package com.demo.example.student_library_management_system_dec2024.repository;

import com.demo.example.student_library_management_system_dec2024.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
