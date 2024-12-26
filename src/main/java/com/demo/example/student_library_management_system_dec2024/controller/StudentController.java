package com.demo.example.student_library_management_system_dec2024.controller;

import com.demo.example.student_library_management_system_dec2024.model.Student;
import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;
import com.demo.example.student_library_management_system_dec2024.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Responseentity - takes the response from APIs and binds it to responseentity and sends it
    // HTTP codes
    // 200 -ok success
//    201-created
//    404-not found
//    400-bad request
//    500-internal server error
//    401-unauthorized

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        try {
            String response = studentService.addStudent(studentRequestDto);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            //System.out.println("Exception occured : "+e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id){
        try {
            Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllStudent(){
        List<Student> studentList = studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
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

    @GetMapping("/findByPage")
    public List<Student> findStudentsBasedOnPage(@RequestParam int pageNo, @RequestParam int pageSize){
        List<Student> studentList = studentService.getStudentsBasedOnPage(pageNo,pageSize);
        return studentList;
    }

    @GetMapping("/findByEmail")
    public Student findStudentByEmail(@RequestParam String email){
        Student student = studentService.getStudentByEmail(email);
        return student;
    }

    @GetMapping("/findByEmailOrDept")
    public List<Student> findStudentByEmailOrDept(@RequestParam String email,@RequestParam  String dept){
        List<Student> studentList = studentService.getStudentByEmailOrDept(email,dept);
        return studentList;
    }

    @GetMapping("/findByDept")
    public List<Student> findStudentByDept(@RequestParam  String dept){
        List<Student> studentList = studentService.getStudentByDept(dept);
        return studentList;
    }
}
