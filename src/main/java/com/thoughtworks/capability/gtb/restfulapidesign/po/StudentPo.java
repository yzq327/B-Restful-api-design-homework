package com.thoughtworks.capability.gtb.restfulapidesign.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentPo {

    private String name;

    private String gender;

    private String note;
}
