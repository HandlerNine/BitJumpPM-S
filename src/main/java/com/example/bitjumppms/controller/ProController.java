package com.example.bitjumppms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class ProController {

    @RequestMapping(path = "/{userid}",method = RequestMethod.GET)
    public BaseResponse getUser(@PathVariable int userid){
        MyUser myUser = MyUser.test1();
        myUser.setUserId(userid);
        return BaseResponse.success(myUser);
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseResponse getUserList(){
        MyUser myUser = MyUser.test1();
        List userList = new ArrayList<MyUser>();
        userList.add(myUser);
        return BaseResponse.success(userList);
    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public String put(){
//        return "put";
//    }
}

