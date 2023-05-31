package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/project")
public class    ProController {
    @GetMapping("/{proid}")
    //获取特定的项目信息
    //order是排序方式，默认为按照开始时间排序
    public BaseResponse getProject(@PathVariable Integer proid,
                                   @RequestParam(required=false, defaultValue="0") Integer order){
        log.info("order = {}",order);
        Project project = Project.test1();
        project.setMembers(new ArrayList<>(Arrays.asList(MyUser.test1(),MyUser.test2())));
        project.setTable(new ArrayList<>(Arrays.asList(TableItem.test1(),TableItem.test2())));
        return BaseResponse.success(project);
    }

    /**
     * 项目管理页面
     */
    @GetMapping("/list")
    //项目列表
    public BaseResponse getProList(@RequestParam(required=false, defaultValue="0") Integer type){
        log.info("type = {}",type);
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(Project.test1());
        projects.add(Project.test2());
        return BaseResponse.success(projects);
    }

    @PostMapping("/create")
    //创建新的项目
    public BaseResponse createProject(@RequestBody Project project){
        log.info("项目名字={}",project.getProjectName());
        return BaseResponse.success();
    }


    @PostMapping("/apply")
    //申请创建权限
    //hashMap中的key为userId和description
    public BaseResponse applyAuthorization(@RequestBody HashMap<String,String> hashMap){
        log.info("id={},des = {}",hashMap.get("userId"),hashMap.get("description"));
        return BaseResponse.success();
    }

    @DeleteMapping("/{proid}")
    //删除项目
    public BaseResponse deleteProject(@PathVariable Integer proid){
        log.info("proid={}",proid);
        return BaseResponse.success();
    }
    /**
     * 项目内容
     */
    @PostMapping("/{proid}/tableitem/{itemid}/delete")
    //驳回项目表项
    public BaseResponse deleteTableItem(@PathVariable Integer proid, @PathVariable Integer itemid,
                                        @RequestBody String reason){
        log.info("{}",reason);
        return BaseResponse.success();
    }

    @PutMapping("/{proid}/tableitem/{itemid}")
    //修改项目表项
    public BaseResponse putTableItem(@PathVariable Integer proid, @PathVariable Integer itemid,
                                     @RequestBody TableItem tableItem){
        log.info("{}",tableItem.getTableItemId());
        return BaseResponse.success();
    }

    @PostMapping("/{proid}/tableitem")
    //添加项目表项
    public BaseResponse addTableItem(@PathVariable Integer proid, @RequestBody TableItem tableItem){
        log.info("{}",tableItem.getTableItemId());
        return BaseResponse.success();
    }

    @PostMapping("/{proid}/tableitem/{itemid}")
    //提交项目表项
    //hashMap中的key为submitTime和description
    public BaseResponse submitTableItem(@PathVariable Integer proid, @PathVariable Integer itemid,
                                        @RequestBody HashMap<String,String> hashMap){
        log.info("submitTime = {}",hashMap.get("submitTime"));
        return BaseResponse.success();
    }

    @PutMapping("/{proid}")
    //修改项目介绍
    public BaseResponse putProDescription(@PathVariable Integer proid, @RequestBody Project project){
        log.info("{}",project.getLeaderId());
        return BaseResponse.success();
    }
    /**
     * 人员增删
     */
    @PostMapping("/{proid}/user")
    //添加新成员
    public BaseResponse addUser(@PathVariable Integer proid,
                                @RequestBody HashMap<String,String> hashMap){
        log.info("id = {}",hashMap.get("userId"));
        return BaseResponse.success();
    }

    @DeleteMapping("/{proid}/user")
    //删除新成员
    public BaseResponse deleteUser(@PathVariable Integer proid,
                                   @RequestParam Integer userId){
        log.info("userid = {}",userId);
        return BaseResponse.success();
    }

    @PutMapping("/{proid}/manager")
    //设置管理员
    //hashMap的key有id、name、isUp
    public BaseResponse setManager(@PathVariable Integer proid,
                                   @RequestBody HashMap<String,Object> hashMap){
        log.info("id = {}, name = {}, isUp = {}",hashMap.get("userId"),hashMap.get("name"),hashMap.get("isUp"));
        return BaseResponse.success();
    }

    @PostMapping("{proid}/change")
    public BaseResponse changeUser(@PathVariable Integer proid){
        return BaseResponse.success();
    }

}

