package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import ch.qos.logback.core.BasicStatusManager;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentRepository {

    private  static  final List<Student>  studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "YZQ", "femail", "可可爱爱"));
        studentList.add(new Student(2, "Joey", "mail", "乖乖巧巧"));
        studentList.add(new Student(3, "zoe", "mail", "帅气逼人"));
        studentList.add(new Student(4, "Tom", "mail", "一班"));
        studentList.add(new Student(5, "Rose", "mail", "二班"));
        studentList.add(new Student(6, "Reachle", "mail", "三班"));
        studentList.add(new Student(7, "Channer", "mail", "四班"));
        studentList.add(new Student(8, "Monika", "mail", "五班"));
    }

    public List<Student> getStudents() {
        return studentList;
    }

    public void createStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudent(Integer id) {
        Iterator<Student> iter = studentList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if(student.getId() == id){
                iter.remove();
            }
        }
    }





}
