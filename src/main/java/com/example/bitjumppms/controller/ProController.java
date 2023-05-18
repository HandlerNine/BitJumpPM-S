package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.*;
import com.example.bitjumppms.exception.ServiceException;
import com.example.bitjumppms.utils.JwtUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/project")
public class ProController {
    /**
     * 获取项目
     */
    @GetMapping("/list/{type}")
    //项目列表
    public BaseResponse getProList(@PathVariable int type){
        log.info("getprolist");
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(Project.test1());
        projects.add(Project.test2());
        return BaseResponse.success(projects);
    }

    @GetMapping("{proid}/user")
    public BaseResponse getProUser(@PathVariable int proid){
        ArrayList<MyUser> users = new ArrayList<>();
        users.add(MyUser.test1());
        users.add(MyUser.test2());
        return BaseResponse.success(users);
    }

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
    public BaseResponse applyAuthorization(@RequestBody HashMap<String,String> hashMap){
        log.info("id={},des = {}",hashMap.get("userId"),hashMap.get("description"));
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
    @PutMapping("/{proid}")
    //修改项目介绍
    public BaseResponse putProDescription(@PathVariable int proid, @RequestBody Project project){
        log.info("{}",project.getLeaderId());
        return BaseResponse.success();
    }

    @GetMapping("/{proid}")
    //获取项目
    public BaseResponse getProject(@PathVariable int proid){
        log.info("getProject");
        Project project = Project.test1();
        project.setMembers(new ArrayList<>(Arrays.asList(MyUser.test1(),MyUser.test2())));
        project.setTable(new ArrayList<>(Arrays.asList(TableItem.test1(),TableItem.test2())));
        return BaseResponse.success(project);
    }

    @PostMapping("/{proid}/tableitem")
    //修改项目表项
    public BaseResponse addTableItem(@PathVariable int proid, @RequestBody TableItem tableItem){
        log.info("{}",tableItem.getTableItemId());
        return BaseResponse.success();
    }

    @PutMapping("/{proid}/tableitem/{itemid}")
    //修改项目表项
    public BaseResponse putTableItem(@PathVariable int proid, @PathVariable int itemid,
                                     @RequestBody TableItem tableItem){
        log.info("{}",tableItem.getTableItemId());
        return BaseResponse.success();
    }

    @DeleteMapping("/{proid}/tableitem/{itemid}")
    //驳回项目表项
    public BaseResponse deleteTableItem(@PathVariable int proid, @PathVariable int itemid,
                                     @RequestBody String reason){
        log.info("{}",reason);
        return BaseResponse.success();
    }

    /**
     * 人员修改
     */
    @PostMapping("/{proid}/user")
    //添加新成员
    public BaseResponse addUser(@PathVariable int proid,
                                @RequestBody HashMap<String,String> hashMap){
        log.info("id = {}, name = {}",hashMap.get("userId"),hashMap.get("name"));
        return BaseResponse.success();
    }

    @DeleteMapping("/{proid}/user")
    //删除新成员
    public BaseResponse deleteUser(@PathVariable int proid,
                                @RequestBody HashMap<String,String> hashMap){
        log.info("id = {}, name = {}",hashMap.get("userId"),hashMap.get("name"));
        return BaseResponse.success();
    }

    @PutMapping("/{proid}/manager")
    //设置管理员
    public BaseResponse setManager(@PathVariable int proid,
                                @RequestBody HashMap<String,Object> hashMap){
        log.info("id = {}, name = {}",hashMap.get("userId"),hashMap.get("name"));
        return BaseResponse.success();
    }

    @PostMapping("{proid}/change")
    public BaseResponse changeUser(@PathVariable int proid){
        return BaseResponse.success();
    }

}

