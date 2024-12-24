package com.demo.example.student_library_management_system_dec2024.converters;

import com.demo.example.student_library_management_system_dec2024.model.Student;
import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;

public class StudentConverter {

    // converters - converts the coming input request dto into model or entity class which represents database table.

    // converts the studentRequestDto into student model class

    public static Student convertsStudentRequestDtoToStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setMobile(studentRequestDto.getMobile());
        student.setGender(studentRequestDto.getGender());
        student.setEmail(studentRequestDto.getEmail());
        student.setDob(studentRequestDto.getDob());
        student.setDept(studentRequestDto.getDept());
        return student;
    }
}
