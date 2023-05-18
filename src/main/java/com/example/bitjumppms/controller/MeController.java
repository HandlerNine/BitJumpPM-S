package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.BaseResponse;
import com.example.bitjumppms.domain.MyUser;
import com.example.bitjumppms.domain.TableItem;
import com.example.bitjumppms.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/me")
public class MeController {

    @PutMapping("/info")
    //修改自己的信息
    public BaseResponse putMyInfo(@RequestBody MyUser myUser){
        log.info("id = {}",myUser.getUserId());
        return BaseResponse.success();
    }

    @GetMapping("/info")
    //获取自己的信息
    public BaseResponse getMyInfo(){
        return BaseResponse.success(MyUser.test1());
    }

    @PutMapping("/password/{oldpassword}/{newpassword}")
    //修改密码
    public BaseResponse putPassword(@PathVariable String oldpassword,
                                    @PathVariable String newpassword,
                                    HttpServletRequest request){
        //获取token（我猜要）
        String token = request.getHeader("token");
        String userId = JwtUtils.extractUserid(token);

        return BaseResponse.success();
    }

    @PostMapping("/logout")
    //退出登录
    public BaseResponse postLogout(){
        return BaseResponse.success();
    }

    //获取日程信息
    @GetMapping("/schedule")
    public BaseResponse getSchedule(){
        ArrayList<TableItem> tableItems = new ArrayList<>();
        tableItems.add(TableItem.test1());
        tableItems.add(TableItem.test2());
        return BaseResponse.success(tableItems);
    }
}
