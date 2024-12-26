package com.demo.example.student_library_management_system_dec2024.service;

import com.demo.example.student_library_management_system_dec2024.converters.StudentConverter;
import com.demo.example.student_library_management_system_dec2024.model.Card;
import com.demo.example.student_library_management_system_dec2024.model.Student;
import com.demo.example.student_library_management_system_dec2024.repository.StudentRepository;
import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        if(!studentOptional.isPresent()){
            throw new RuntimeException("Student not found with id : "+id);
        }
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

    /*
    Pagination - displaying or fetching the records or data in the form of pages
    pagenumber - the number of page we want see(page numbers starts from 0,1,2,3,4...)
    pagesize - total number of record in a page (this is fixed for each page)

    database record/data = 28, pagesize =5
    0th page ->1-5
    1st page ->6-10
    2nd page ->11-15
    3rd page ->16-20
    4th page ->21-25
    5th page ->26-28

    database records =11, pagesize=2
    0th page ->1-2
    1st page ->3-4
    2nd page ->5-6
    3rd page ->7-8
    4th page ->9-10
    5th page ->11

    sorting - arranging the records/data in ascedong or descending order

     */

    public List<Student> getStudentsBasedOnPage(int pageNo, int pageSize){
        // only pagination - Page<Student> studentPage = studentRepository.findAll(PageRequest.of(pageNo,pageSize));

        // pagination and sorting
        Page<Student> studentPage = studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by("name").ascending()));
        // we should convert page into list
        List<Student> studentList = studentPage.getContent();
        return studentList;
    }

    public Student getStudentByEmail(String email){
        Student student = studentRepository.findByEmail(email);
        return student;
    }

    public List<Student> getStudentByEmailOrDept(String email, String dept){
        List<Student> studentList = studentRepository.findByEmailOrDept(email,dept);
        return studentList;
    }

    public List<Student> getStudentByDept(String dept){
        List<Student> studentList = studentRepository.findByDeptQuery(dept);
        return studentList;
    }

}
