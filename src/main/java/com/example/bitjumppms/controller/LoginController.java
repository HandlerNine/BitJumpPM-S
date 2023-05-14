package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.BaseResponse;
import com.example.bitjumppms.domain.ErrorCode;
import com.example.bitjumppms.exception.GlobalExceptionHandler;
import com.example.bitjumppms.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Slf4j
public class LoginController {
    @PostMapping("/register/{userid}/{password}")
    // 注册
    public BaseResponse register(@PathVariable String userid, @PathVariable String password,
                                 @RequestBody HashMap<String, String> map){
        //处理
        log.info("userid = {}, password = {}, email = {} ",userid,password,map.get("email"));
        if(false)
            return BaseResponse.success();
        else{
            throw new ServiceException(ErrorCode.DUPLICATE_USERNAME,"用户已存在");
        }
    }

    @RequestMapping("/login/{userid}/{password}")
    //登录
    public BaseResponse login(@PathVariable String userid, @PathVariable String password){
        log.info("userid = {}, password = {}",userid,password);
        if(false)
            return BaseResponse.success();
        else{
            throw new ServiceException(ErrorCode.DUPLICATE_USERNAME,"密码错误");
        }
    }
}
