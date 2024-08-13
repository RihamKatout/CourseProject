package com.exalt.training.controller;

import com.exalt.training.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> allStudent;
    @PostConstruct
    public void loadData(){
        allStudent = new ArrayList<>();
        allStudent.add(new Student(1, "Riham", "Katout", "test@gmail.com"));
        allStudent.add(new Student(2, "Siwar", "Katout", "test2@gmail.com"));
        allStudent.add(new Student(3, "Ahmad", "Muneer", "test3@gmail.com"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return allStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return allStudent.get(studentId);
    }
}