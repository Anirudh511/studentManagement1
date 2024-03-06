package com.studentManagement.service;

import com.studentManagement.entity.Student;
import com.studentManagement.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public String updateStudent(Student student) {
        Long studentId= studentRepo.findById(student.getId()).get().getId();
        if (studentId==student.getId()){
        studentRepo.save(student);
        return "done";
        }
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
//        return "done";
    }


}
