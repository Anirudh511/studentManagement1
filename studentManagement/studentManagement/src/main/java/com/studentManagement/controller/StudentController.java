package com.studentManagement.controller;

import com.studentManagement.entity.Student;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired(required = false)
    Model model;

    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }
    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "newStudent";
    }

/*    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveStudent( Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }*/


    @PostMapping("/students")
    public  String addStudent(@ModelAttribute ("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping(value = "/student")
    public String updateStudent(@ModelAttribute ("student") Student student){
       studentService.updateStudent(student);
       return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
       studentService.deleteStudentById(id);
       return "redirect:/students";
    }
}
