package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepository {

    private static final List<Group> GROUPS = new ArrayList<>();

    private static final Integer GROUP_NUMBER = 6;

    static {
        for (int i = 1; i <= GROUP_NUMBER; i++) {
            GROUPS.add(new Group(i,"第"+ i + "组", "小组成员信息"));
        }
    }

    public List<Group> getGroups() {
        return GROUPS;
    }
}
