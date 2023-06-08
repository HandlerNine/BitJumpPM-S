package com.example.bitjumppms.domain;

import com.chenxf.DB.POJO.User;
import lombok.Data;
import java.io.IOException;

@Data
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
     * 部门（记得改枚举）
     */
    private String department;
    /**
     * 学历
     */
    private String education;
    /**
     * 邮箱(暂时qq)
     */
    private String email;
    /**
     * 入职时间（记得设置时间格式)
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
     * 完整的照片
     */
    private String photo;
    /**
     * 政治面貌
     */
    private String politicalStatus;
    /**
     * 岗位（记得改枚举）
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
     * 项目组（记得改枚举）
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

    public static User toUser(MyUser myuser){
        User user = new  User();

        user.setUserID(myuser.userId);
        user.setEmail(myuser.email);
        user.setName(myuser.name);
        user.setGender(myuser.gender);
        user.setPhoneNumber(myuser.phoneNumber);
        user.setEntryTime(myuser.entryTime);
        user.setDepartment(myuser.department);
        user.setPriv((int) myuser.priv);
        user.setEducation(myuser.education);
        user.setCensusRegister(myuser.censusRegister);
        user.setNationality(myuser.nationality);
        user.setMarriage(myuser.marriage);
        user.setBirthDate(myuser.birthDate);
        user.setAge(String.valueOf(myuser.age));
        user.setBloodType(myuser.bloodType);
        user.setPoliticalStatus(myuser.politicalStatus);
        user.setQQNumber(myuser.qqNumber);
        user.setWechatNumber(myuser.wechatNumber);
        user.setPost(myuser.post);
        user.setAddress(myuser.address);
        user.setSchool(myuser.school);
        user.setMajor(myuser.major);
        user.setPreviousCompany(myuser.previousCompany);
        user.setJobTitle(myuser.jobTitle);
        user.setLimitation(myuser.limitation);
        user.setPhotoUrl(myuser.photo);
        user.setSeniority(String.valueOf(myuser.seniority));

        return user;
    }


}

