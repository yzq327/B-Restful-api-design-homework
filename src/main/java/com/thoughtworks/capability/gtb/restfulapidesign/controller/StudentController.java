package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated

public class StudentController {
    private final StudentService studentService;

    public  StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping(value = "/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    //    @GetMapping(value = "/login")
//    public User getUser(@RequestParam Map<String,String> allParams) {
//        return userService.getUser(allParams);
//    }
    @GetMapping(value = "/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping(value = "/students/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) throws ClassNotFoundException {
        return studentService.getStudentById(id);
    }

}
