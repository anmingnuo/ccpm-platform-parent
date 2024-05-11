package edu.zut.chz.system.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class CourseVo {

    private Long directionId;
    private List<Long> courseIdList;
}
