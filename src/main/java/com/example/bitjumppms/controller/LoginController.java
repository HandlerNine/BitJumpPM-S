package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.BaseResponse;
import com.example.bitjumppms.domain.ErrorCode;
import com.example.bitjumppms.exception.GlobalExceptionHandler;
import com.example.bitjumppms.exception.ServiceException;
import com.example.bitjumppms.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {

    @PostMapping("/register/{userid}/{password}")
    // 注册
    public BaseResponse register(@PathVariable String userid, @PathVariable String password,
                                 @RequestBody HashMap<String, String> map){
        //处理
        log.info("userid = {}, password = {}, email = {} ",userid,password,map.get("email"));
        if(true)
            return BaseResponse.success();
        else{
            //失败（默认httpState为400）
            throw new ServiceException(ErrorCode.DUPLICATE_USERNAME,"用户已存在");
        }
    }

    @GetMapping("/login/{userid}/{password}")
    //登录
    public BaseResponse login(@PathVariable String userid, @PathVariable String password){

        //记得写个解密的方法

        log.info("userid = {}, password = {}",userid,password);
        Map<String, Object> payload = new HashMap<>();
        payload.put("name","hhh");
        String token = new JwtUtils().createToken(payload,userid); //userid放进subject里，其余的消息放payload里
        if(true)
            return BaseResponse.success(token);
        else{
            throw new ServiceException(ErrorCode.INVALID_USERNAME,"用户不存在");
        }
    }

}
