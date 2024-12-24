package com.demo.example.student_library_management_system_dec2024.requestdto;

import com.demo.example.student_library_management_system_dec2024.model.Student;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentRequestDto {
    // Request DTO(data transfer object) - it is used to take input request fields

    private String name;
    private String email;
    private String mobile;
    private String dob;
    private String gender;
    private String dept;


}
