package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.BaseResponse;
import com.example.bitjumppms.domain.MyUser;
import com.example.bitjumppms.domain.TableItem;
import com.example.bitjumppms.utils.JwtUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @PutMapping("/{userid}/info")
    //修改特定人的信息
    public BaseResponse putMyInfo(@RequestBody MyUser myUser,
                                  HttpServletRequest request){
        String userId = JwtUtils.getIdFromRequest(request);

        if(userId.equals(myUser.getUserId())){
            log.info("是本人");
        }
        log.info("id = {}",myUser.getUserId());
        return BaseResponse.success();
    }

    @GetMapping("/{userid}/info")
    //获取特定人员信息
    public BaseResponse getMyInfo(){
        return BaseResponse.success(MyUser.test1());
    }



    @GetMapping("/list")
    // 获取所有人员列表
    public BaseResponse getAllUser(){
        ArrayList<MyUser> users = new ArrayList<>();
        users.add(MyUser.test1());
        users.add(MyUser.test2());
        return BaseResponse.success(users);
    }




    @GetMapping("/schedule")
    //获取日程信息
    public BaseResponse getSchedule(){
        ArrayList<TableItem> tableItems = new ArrayList<>();
        tableItems.add(TableItem.test1());
        tableItems.add(TableItem.test2());
        return BaseResponse.success(tableItems);
    }
}
