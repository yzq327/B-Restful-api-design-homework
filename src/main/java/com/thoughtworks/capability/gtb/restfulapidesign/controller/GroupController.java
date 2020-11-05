package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.po.GroupPo;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j //提供日志接口；提供获取具体日志对象的方法
public class GroupController {

    private final GroupService groupService;

    public GroupController (GroupService groupService) {
        this.groupService = groupService;
    }

    @PatchMapping(value = "/groups/{id}/{name}")
    public void updateGroupName(@PathVariable("id") Integer id, @PathVariable("name") String newName) {
        groupService.updateGroupName(id, newName);
    }

    @GetMapping(value = "/groups")
    public List<GroupPo> getGroups() {
        return groupService.getGroups();
    }


}
