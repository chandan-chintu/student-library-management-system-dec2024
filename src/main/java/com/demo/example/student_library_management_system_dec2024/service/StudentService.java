package com.demo.example.student_library_management_system_dec2024.service;

import com.demo.example.student_library_management_system_dec2024.converters.StudentConverter;
import com.demo.example.student_library_management_system_dec2024.model.Card;
import com.demo.example.student_library_management_system_dec2024.model.Student;
import com.demo.example.student_library_management_system_dec2024.repository.StudentRepository;
import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        // we do not save directly studentRequestDto, we have to first convert it to student model class
        // after that we can save it.

        // convert requestdto into model class so that it is saved in database
        Student student = StudentConverter.convertsStudentRequestDtoToStudent(studentRequestDto);

        // whenever student gets created card also gets created
        Card card = new Card();
        card.setCardStatus("ACTIVE");

        student.setCard(card);
        card.setStudent(student);

        studentRepository.save(student);
        return "Student saved successfully";
    }


    public Student getStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.get();
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String countStudents(){
        long count = studentRepository.count();
        return "Total number of students present are :"+count;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student with id : "+id+" got deleted";
    }

    public String updateStudent(int id, StudentRequestDto studentRequestDto){
        // first find student id is present in database or not
        // if present the update
        // else no update
        Student student = getStudentById(id);
        if(student!=null){
            // update operation can be performed
            student.setName(studentRequestDto.getName());
            student.setGender(studentRequestDto.getGender());
            student.setMobile(studentRequestDto.getMobile());
            student.setEmail(studentRequestDto.getEmail());
            student.setDob(studentRequestDto.getDob());
            student.setDept(studentRequestDto.getDept());

            studentRepository.save(student);
            return "Student updated successfully";
        } else {
            // cannot update
            return " student cannot be updated";
        }
    }

    public String updateStudentByPatch(int id, String mobile){
        // first find student id is present in database or not
        // if present the update
        // else no update
        Student student = getStudentById(id);
        if(student!=null){
            // update operation can be performed
            student.setMobile(mobile);
            studentRepository.save(student);
            return "Student updated successfully";
        } else {
            // cannot update
            return " student cannot be updated";
        }
    }

}
