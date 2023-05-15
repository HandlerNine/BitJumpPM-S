package com.example.bitjumppms.domain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class    Project {
    private int projectId;//项目id
    private String projectName;//项目名字
    private String projectUrl;//图标
    private int process;//进程
    private String department;//部门
    private String introduction;//介绍
    private int budget;//预算
    private String leaderId;//负责人id
    private String leaderName;//负责人名字
    private ArrayList<MyUser> members;//成员
    private ArrayList<TableItem> table;//表项

    public static Project test1(){
        Project project = new Project();
        project.projectId = 1;
        project.projectName = "pro1";
        return project;
    }


}
