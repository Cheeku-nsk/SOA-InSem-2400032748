package com.klu.exam.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.exam.student.model.Student;
import com.klu.exam.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping({"", "/"})
    public String welcome() {
        return "Welcome to student service";
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody(required = false) Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping({"/displaystudent", "/displayStudent", "/displaystudents", "/displayStudents"})
    public List<Student> displaystudent() {
        return studentService.displaystudent();
    }

    @GetMapping({"/displaystudent/{id}", "/displayStudent/{id}"})
    public Student displaystudentById(@PathVariable Long id) {
        return studentService.displaystudent(id);
    }
}
