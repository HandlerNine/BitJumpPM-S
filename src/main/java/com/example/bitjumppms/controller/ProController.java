package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.BaseResponse;
import com.example.bitjumppms.domain.ErrorCode;
import com.example.bitjumppms.domain.MyUser;
import com.example.bitjumppms.domain.Project;
import com.example.bitjumppms.exception.ServiceException;
import com.example.bitjumppms.utils.JwtUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/project")
public class ProController {

    /**
     * 项目增删
    */
    @PostMapping("/create")
    //创建新的项目
    public BaseResponse createProject(@RequestBody Project project){
        log.info("项目名字={}",project.getProjectName());
        return BaseResponse.success();
    }

    @PostMapping("/apply")
    //申请创建权限
    public BaseResponse applyAuthorization(@RequestBody HashMap<String,String> hashMap,
                                           HttpServletRequest request){
        log.info("id={},des = {}",hashMap.get("userId"),hashMap.get("description"));
        String token = request.getHeader("token");
//        String name = JwtUtils.extractUserid(token);
//        log.info("token id = {}",name);
        return BaseResponse.success();
    }

    @DeleteMapping("/{proid}")
    //删除项目
    public BaseResponse deleteProject(@PathVariable int proid){
        log.info("proid={}",proid);
        return BaseResponse.success();
    }

    /**
     * 项目内容修改
     */

//    @PutMapping("/{proid}")
    //修改项目介绍
//    public BaseResponse putProDescription(@PathVariable int proid, @RequestBody Project project){
//        log.info("{}",);
//        return BaseResponse.success();
//    }
}

