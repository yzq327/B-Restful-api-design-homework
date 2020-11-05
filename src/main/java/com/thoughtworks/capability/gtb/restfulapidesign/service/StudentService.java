package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.po.StudentPo;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(StudentPo studentPo) {
        Student student = Student.builder().id(9)
                                .name(studentPo.getName())
                                .gender(studentPo.getGender())
                                .note(studentPo.getNote()).build();
        studentRepository.createStudent(student);
    }

    public List<Student> getStudents(String gender) {
        List<Student> studentList = studentRepository.getStudents();
        if(gender != null) {
            Iterator<Student> iter = studentList.iterator();
            List<Student> students = new ArrayList<>();
            while (iter.hasNext()) {
                Student student = iter.next();
                if(student.getGender().equals(gender)){
                    students.add(student);
                }
            }
            return students;
        }
        return studentList;
    }

    public Student getStudentByName(String name) throws ClassNotFoundException {
        List<Student> studentList = studentRepository.getStudents();
        Iterator<Student> iter = studentList.iterator();
        List<Student> students = new ArrayList<>();
        while (iter.hasNext()) {
            Student student = iter.next();
            if(student.getName().equals(name)){
                students.add(student);
            }
        }
        if(students.size() == 0){
           throw  new ClassNotFoundException("用户不存在");
        }
        return  students.get(0);
    }

    public void deleteStudentById(Integer id) throws ClassNotFoundException {
        List<Student> studentList = studentRepository.getStudents();
        Iterator<Student> iter = studentList.iterator();
        List<Student> students = new ArrayList<>();
        while (iter.hasNext()) {
            Student student = iter.next();
            if(student.getId() == id){
                students.add(student);
            }
        }
        if(students.size() == 0){
            throw  new ClassNotFoundException("用户Id不存在");
        }
        studentRepository.deleteStudent(id);
    }

    public Student updateStudentById(Integer id, StudentPo studentPo) throws ClassNotFoundException {
        List<Student> studentList = studentRepository.getStudents();
        Iterator<Student> iter = studentList.iterator();
        List<Student> students = new ArrayList<>();
        while (iter.hasNext()) {
            Student student = iter.next();
            if(student.getId() == id){
                students.add(student);
            }
        }
        if(students.size() == 0){
            throw  new ClassNotFoundException("用户Id不存在");
        }
        Student updateStudent = students.get(0);
        if(studentPo.getName() != null){
            updateStudent.setName(studentPo.getName());
        }
        if(studentPo.getGender() != null){
            updateStudent.setGender(studentPo.getGender());
        }
        if(studentPo.getNote() != null){
            updateStudent.setNote(studentPo.getNote());
        }
        return updateStudent;



    }

}
