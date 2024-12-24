package com.demo.example.student_library_management_system_dec2024.requestdto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorRequestDto {

    private String name;
    private String email;
    private String country;
    private Double rating;
}
