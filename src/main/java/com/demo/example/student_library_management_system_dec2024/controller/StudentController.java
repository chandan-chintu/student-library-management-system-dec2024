package com.demo.example.student_library_management_system_dec2024.controller;

import com.demo.example.student_library_management_system_dec2024.model.Student;
import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;
import com.demo.example.student_library_management_system_dec2024.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        String response = studentService.addStudent(studentRequestDto);
        return response;
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudent(){
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @GetMapping("/count")
    public String countStudents(){
        String response = studentService.countStudents();
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteStudentById(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public String updateStudentById(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.updateStudent(id,studentRequestDto);
        return response;
    }

    // @RequestParam - takes request as query parameters
    @PatchMapping("/updatePatch/{id}")
    public String updateStudentMobileByPatch(@PathVariable int id,@RequestParam String mobile){
        String response = studentService.updateStudentByPatch(id,mobile);
        return response;
    }
}
