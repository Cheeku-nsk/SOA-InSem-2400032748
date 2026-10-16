package com.klu.exam.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.klu.exam.student.controller.StudentController;
import com.klu.exam.student.model.Student;
import com.klu.exam.student.service.StudentService;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    private StudentController studentController;

    @Autowired
    private StudentService studentService;

    @Test
    void testDisplayStudent() {
        List<Student> students = studentController.displaystudent();
        assertNotNull(students);
        assertTrue(students.size() >= 1);
        Student first = students.get(0);
        assertNotNull(first.getId());
        assertEquals("Kousik", first.getName());
        assertEquals("CSE", first.getDepartment());
    }

    @Test
    void testAddAndDisplayStudent() {
        Student newStudent = new Student("Rahul", "ECE");
        Student saved = studentController.addStudent(newStudent);
        assertNotNull(saved.getId());

        List<Student> students = studentController.displaystudent();
        assertNotNull(students);
        assertTrue(students.stream().anyMatch(s -> "Rahul".equals(s.getName())));

        Student found = studentController.displaystudentById(saved.getId());
        assertNotNull(found);
        assertEquals("Rahul", found.getName());
    }
}
