package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.po.StudentPo;
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
    public void createUser(@RequestBody StudentPo studentPo) {
        studentService.createStudent(studentPo);
    }

    @GetMapping(value = "/students")
    public List<Student> getStudents(@RequestParam(required = false) String gender){
        return studentService.getStudents(gender);
    }

    @GetMapping(value = "/students/{name}")
    public Student getStudentByName(@PathVariable("name") String name) throws ClassNotFoundException {
        return studentService.getStudentByName(name);
    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudentById(@PathVariable("id") Integer id) throws ClassNotFoundException {
        studentService.deleteStudentById(id);
    }

    @PatchMapping(value = "/students/{id}")
    public Student updateStudentById(@PathVariable("id") Integer id, @RequestBody StudentPo studentPo) throws ClassNotFoundException {
        return studentService.updateStudentById(id, studentPo);
    }

}
