package com.demo.example.student_library_management_system_dec2024.repository;

import com.demo.example.student_library_management_system_dec2024.model.Author;
import com.demo.example.student_library_management_system_dec2024.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
