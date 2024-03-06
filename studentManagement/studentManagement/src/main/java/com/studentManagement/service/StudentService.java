package com.studentManagement.service;

import com.studentManagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudent();
    Student saveStudent(Student  student);

    Student getStudentById(Long id);
    String updateStudent(Student student);
    void  deleteStudentById(Long id);
}
