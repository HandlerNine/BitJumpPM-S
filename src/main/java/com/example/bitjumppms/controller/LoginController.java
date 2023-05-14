package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class LoginController {
    @PostMapping("/register/{userid}/{password}")
    // 注册
    public BaseResponse register(@PathVariable String userid, @PathVariable String password,
                                 @RequestParam(value = "email") String email){
        //处理
        log.info("userid = {}, password = {}, email = {} ",userid,password,email);
        return BaseResponse.success();
    }

//    @RequestMapping("/login/{userid}/{password}")

}
