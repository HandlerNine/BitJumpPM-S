package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.BaseResponse;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/register")
public class RegisterController {
    @RequestMapping("/{userid}/{password}")
    public BaseResponse register(@PathVariable String userid, @PathVariable String password){
        //处理
        log.info("userid = {}, password = {}",userid,password);
        return BaseResponse.success();
    }

}
