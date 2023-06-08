package com.example.bitjumppms.controller;

import com.chenxf.DB.DBController;
import com.chenxf.DB.POJO.Task;
import com.chenxf.DB.POJO.User;
import com.example.bitjumppms.domain.*;
import com.example.bitjumppms.utils.JwtUtils;
import com.example.bitjumppms.utils.ObjTransferUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:5173",maxAge = 3600)
@RequestMapping("/project")
public class    ProController {
    DBController db;
    ProController() throws IOException {
        db = new DBController();
    }

    @GetMapping("/{proid}")
    //获取特定的项目信息
    //order是排序方式，默认为按照开始时间排序
    public BaseResponse getProject(@PathVariable Integer proid,
                                   @RequestParam(required=false, defaultValue="0") Integer order,
                                   HttpServletRequest request){
        log.info("order = {}",order);
        com.chenxf.DB.POJO.Project projectInfo = this.db.SelectProjectInfoByID(proid);
        ArrayList<User> projectMemberInfos = (ArrayList<User>) this.db.SelectProjectMemberInfoByProjectID(proid);
        ArrayList<Task> projectTaskInfos = (ArrayList<Task>) this.db.SelectTasksInfoByProjectID(proid);

        Project project = ObjTransferUtil.ToProject(projectInfo,projectTaskInfos,projectMemberInfos);
        return BaseResponse.success(project);
    }

    /**
     * 项目管理页面
     */
    @GetMapping("/list")
    //项目列表
    public BaseResponse getProList(@RequestParam Integer type,
                                   HttpServletRequest request){
        log.info("type = {}",type);
//        ArrayList<Project> projects = new ArrayList<>();
//        projects.add(Project.test1());
//        projects.add(Project.test2());

        String userId = JwtUtils.getIdFromRequest(request);
        ArrayList<com.chenxf.DB.POJO.Project> projectInfos = (ArrayList<com.chenxf.DB.POJO.Project>) this.db.SelectProjectsInfoByUserID(type,userId);

        return BaseResponse.success(ObjTransferUtil.ListToProject(projectInfos));
    }

    @PostMapping("/create")
    //创建新的项目
    public BaseResponse createProject(@RequestBody Project project,
                                      HttpServletRequest request){
        log.info("项目名字={}",project.getProjectName());

        com.chenxf.DB.POJO.Project chenxfProject = ObjTransferUtil.ProjectToProjectInfo(project);

        String userId = JwtUtils.getIdFromRequest(request);
        chenxfProject.setMasterID(userId);

        this.db.InsertProject(chenxfProject);

        return BaseResponse.success();
    }


    @PostMapping("/apply")
    //申请创建权限
    //hashMap中的key为userId和description
    public BaseResponse applyAuthorization(@RequestBody HashMap<String,String> hashMap,
                                           HttpServletRequest request){
        log.info("id={},des = {}",hashMap.get("userId"),hashMap.get("description"));

        // xixixi

        return BaseResponse.success();
    }

    @DeleteMapping("/{proid}")
    //删除项目
    public BaseResponse deleteProject(@PathVariable Integer proid,
                                      HttpServletRequest request){
        log.info("proid={}",proid);

        this.db.DeleteProjectByID(proid);

        return BaseResponse.success();
    }
    /**
     * 项目内容
     */
    @PostMapping("/{proid}/tableitem/{itemid}/delete")
    //驳回项目表项
    public BaseResponse deleteTableItem(@PathVariable Integer proid, @PathVariable Integer itemid,
                                        @RequestBody String reason,
                                        HttpServletRequest request){
        //TODO
        //直接驳回就行了
        //显然没写

        this.db.RefuseTask(itemid,reason);

        log.info("{}",itemid);
        log.info("{}",reason);
        return BaseResponse.success();
    }

    @PutMapping("/{proid}/tableitem/{itemid}")
    //修改项目表项
    public BaseResponse putTableItem(@PathVariable Integer proid, @PathVariable Integer itemid,
                                     @RequestBody TableItem tableItem,
                                     HttpServletRequest request){

        Task task = ObjTransferUtil.TableItemToTask(tableItem);

        task.setProjectID(proid);

        log.info("in modifiying");
        log.info(task.toString());
        task.setTaskID(itemid);
        //数据库修改
        db.UpdateTaskInfo(task);

        return BaseResponse.success();
    }

    @PostMapping("/{proid}/tableitem")
    //添加项目表项
    public BaseResponse addTableItem(@PathVariable Integer proid, @RequestBody TableItem tableItem,
                                     HttpServletRequest request){

        Task task = ObjTransferUtil.TableItemToTask(tableItem);
        task.setProjectID(proid);
        //添加
        db.InsertTask(task);

        return BaseResponse.success();
    }

    @PostMapping("/{proid}/tableitem/{itemid}")
    //提交项目表项
    //hashMap中的key为submitTime和description
    public BaseResponse submitTableItem(@PathVariable Integer proid, @PathVariable Integer itemid,
                                        @RequestBody HashMap<String,String> hashMap,
                                        HttpServletRequest request){
        String submitTime = hashMap.get("submitTime");
        String description = hashMap.get("description");
        //TODO
        //提交表项
        //这个类似于修改，只要改check和submitTime就行了

        this.db.CommitTask(itemid,submitTime,description);

        return BaseResponse.success();
    }

    @PutMapping("/{proid}")
    //修改项目介绍
    public BaseResponse putProDescription(@PathVariable Integer proid, @RequestBody Project project,
                                          HttpServletRequest request){

        com.chenxf.DB.POJO.Project projectInfo = ObjTransferUtil.ProjectToProjectInfo(project);
        //数据库修改
        db.UpdateProjectInfo(projectInfo);

        return BaseResponse.success();
    }
    /**
     * 人员增删
     */
    @PostMapping("/{proid}/user")
    //添加新成员
    public BaseResponse addUser(@PathVariable Integer proid,
                                @RequestBody HashMap<String,String> hashMap,
                                HttpServletRequest request){

        String userId = hashMap.get("userId");
        //数据库添加成员
        db.InsertCrew(proid,userId);

        return BaseResponse.success();
    }

    @DeleteMapping("/{proid}/user")
    //删除新成员
    public BaseResponse deleteUser(@PathVariable Integer proid,
                                   @RequestParam String userId,
                                   HttpServletRequest request){
        //数据库删除成员
        db.DeleteCrew(proid,userId);

        return BaseResponse.success();
    }

    @PutMapping("/{proid}/manager")
    //设置管理员
    //hashMap的key有id、name、isUp
    public BaseResponse setManager(@PathVariable Integer proid,
                                   @RequestBody HashMap<String,Object> hashMap,
                                   HttpServletRequest request){

        String userId = (String) hashMap.get("userId");
        String name = (String) hashMap.get("name");
        Boolean isUp = (Boolean) hashMap.get("isUp");

        //数据库处理
        db.UpdateCrewPriv(proid,userId,isUp);

        log.info("id = {}, name = {}, isUp = {}",hashMap.get("userId"),hashMap.get("name"),hashMap.get("isUp"));
        return BaseResponse.success();
    }

    @PostMapping("{proid}/change")
    public BaseResponse changeUser(@PathVariable Integer proid,
                                   HttpServletRequest request){
        return BaseResponse.success();
    }

}

