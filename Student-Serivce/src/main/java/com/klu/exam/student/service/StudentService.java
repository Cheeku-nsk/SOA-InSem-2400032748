package com.klu.exam.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.exam.student.model.Student;
import com.klu.exam.student.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired(required = false)
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        if (student == null) {
            student = new Student();
            student.setName("Kousik");
            student.setDepartment("CSE");
        } else {
            if (student.getName() == null) {
                student.setName("KLU Student");
            }
            if (student.getDepartment() == null) {
                student.setDepartment("CSE");
            }
        }

        if (studentRepository != null) {
            if (student.getId() != null && !studentRepository.existsById(student.getId())) {
                student.setId(null);
            }
            return studentRepository.save(student);
        }

        if (student.getId() == null) {
            student.setId(101L);
        }
        return student;
    }

    public List<Student> displaystudent() {
        if (studentRepository != null) {
            List<Student> students = studentRepository.findAll();
            if (!students.isEmpty()) {
                return students;
            }
            // When repository is empty, seed and save default student details
            Student defaultStudent = new Student("Kousik", "CSE");
            studentRepository.save(defaultStudent);
            return studentRepository.findAll();
        }
        List<Student> defaultList = new ArrayList<>();
        defaultList.add(new Student(101L, "Kousik", "CSE"));
        return defaultList;
    }

    public Student displaystudent(Long id) {
        if (studentRepository != null) {
            return studentRepository.findById(id).orElse(null);
        }
        return new Student(id, "Kousik", "CSE");
    }

    public List<Student> displayStudent() {
        return displaystudent();
    }

    public Student displayStudent(Long id) {
        return displaystudent(id);
    }
}
