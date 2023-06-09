package com.example.bitjumppms.domain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class    Project {
    private Integer projectId;//项目id
    private String projectName;//项目名字
    private String projectPhoto;//图标
    private Integer process;//进程
    private String department;//部门
    private String introduction;//介绍
    private Integer budget;//预算
    private String leaderId;//负责人id
    private String leaderName;//负责人名字
    //赖得手写结构了，如果这样一整个传不行的话就用再写一个结构或者HashMap吧
    private ArrayList<MyUser> members;//成员
    private ArrayList<TableItem> table;//表项

    public static Project test1(){
        Project project = new Project();
        project.projectId = 1;
        project.projectName = "pro1";
        return project;
    }

    public static Project test2(){
        Project project = new Project();
        project.projectId = 2;
        project.projectName = "pro1";
        return project;
    }


}
