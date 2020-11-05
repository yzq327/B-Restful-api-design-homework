package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.po.GroupPo;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private static final Integer GROUP_NUMBER = 6;

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private List<GroupPo> groupPoList;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public void updateGroupName(Integer id, String newName) {
        groupRepository.getGroups().get(id-1).setName(newName);
    }

    public List<GroupPo> getGroups() {
        if(groupPoList == null) {
            return createGroupPoist();
        }
        return groupPoList;
    }

    private  List<GroupPo> createGroupPoist() {
        groupPoList = new ArrayList<GroupPo>();
        for(int i=1; i<= GROUP_NUMBER; i++) {
            groupPoList.add(new GroupPo(
                    groupRepository.getGroups().get(i-1).getName(),
                    groupRepository.getGroups().get(i-1).getNote(), new ArrayList<>()));
        }

        for (GroupPo groupPo : groupPoList){
            groupPo.getStudentList().clear();
        }
        List<Student> studentList = studentRepository.getStudents();
        Collections.shuffle(studentList);
        int index = 0;
        for (Student student : studentList){
            groupPoList.get(index).getStudentList().add(student);
            index = (index + 1) % GROUP_NUMBER;
        }
        return groupPoList;
    }

}
