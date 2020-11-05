package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public StudentService() {
        studentMap.put(1, new Student(1, "yangzhengqing", "femail", "可可爱爱"));
        studentMap.put(2, new Student(2, "hhhhhhhhh", "mail", "乖乖巧巧"));
    }

    public void createStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        for(int i=0; i< studentMap.size(); i++){
            studentList.add(studentMap.get(i));
        }
        return studentList;
    }

    public Student getStudentById(Integer id) throws ClassNotFoundException {
        Student student = studentMap.get(id);
        if(student == null) {
            throw new ClassNotFoundException();
        }
        return student;
    }
}
