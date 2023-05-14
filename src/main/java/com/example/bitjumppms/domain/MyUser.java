package com.example.bitjumppms.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyUser {
    private int userId;//用户id
    private int priv;//权限
    private String fistName;//名
    private String lastName;//姓
    private String gender;//性别
    private int age;//年龄
    private String post;//职位
    private String photoUrl;//头像url
    private String entryTime;//入职时间
    private String department;//所属部门
    private String projectTeam;//项目组
    private String education;//学历
    private String email;//邮箱


    public static MyUser test1(){
        MyUser user = new MyUser();
        user.userId = 1;
        user.fistName = "wen";
        user.lastName = "tan";
        return user;
    }
}
