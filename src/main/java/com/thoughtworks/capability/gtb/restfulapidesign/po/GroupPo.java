package com.thoughtworks.capability.gtb.restfulapidesign.po;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupPo {

    private String name;

    private String note;

    private List<Student> studentList;
}
