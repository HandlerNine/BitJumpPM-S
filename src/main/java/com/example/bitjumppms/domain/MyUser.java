package com.example.bitjumppms.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class MyUser {
    /**
     * 地址
     */
    private String address;
    /**
     * 年龄
     */
    private long age;
    /**
     * 生日（记得改日期格式）
     */
    private String birthDate;
    /**
     * 血型
     */
    private String bloodType;
    /**
     * 户籍
     */
    private String censusRegister;
    /**
     * 创建的项目id
     */
    private long[] createdProId;
    /**
     * 部门
     */
    private String department;
    /**
     * 学历
     */
    private String education;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 入职时间
     */
    private String entryTime;
    /**
     * 性别
     */
    private String gender;
    /**
     * 职称
     */
    private String jobTitle;
    /**
     * 加入的项目id
     */
    private long[] joinedProId;
    /**
     * 竞业限制
     */
    private String limitation;
    /**
     * 专业
     */
    private String major;
    /**
     * 管理的项目id
     */
    private long[] managedProId;
    /**
     * 婚姻
     */
    private String marriage;
    /**
     * 姓名
     */
    private String name;
    /**
     * 民族
     */
    private String nationality;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 照片url
     */
    private String photoUrl;
    /**
     * 政治面貌
     */
    private String politicalStatus;
    /**
     * 岗位
     */
    private String post;
    /**
     * 上家公司
     */
    private String previousCompany;
    /**
     * 权限
     */
    private long priv;
    /**
     * 项目组
     */
    private String projectTeam;
    /**
     * QQ
     */
    private String qqNumber;
    /**
     * 毕业学校
     */
    private String school;
    /**
     * 工龄
     */
    private long seniority;
    /**
     * 账号
     */
    private String userId;
    /**
     * 微信
     */
    private String wechatNumber;

    public static MyUser test1(){
        MyUser myUser = new MyUser();
        myUser.userId = "12345";
        myUser.name = "fueiui";
        return myUser;
    }

    public static MyUser test2(){
        MyUser myUser = new MyUser();
        myUser.userId = "13548";
        myUser.name = "fufeui";
        return myUser;
    }

}

