package com.example.bitjumppms.controller;

import com.chenxf.DB.DBController;
import com.chenxf.DB.POJO.Task;
import com.chenxf.DB.POJO.User;
import com.example.bitjumppms.domain.BaseResponse;
import com.example.bitjumppms.domain.MyUser;
import com.example.bitjumppms.domain.Schedule;
import com.example.bitjumppms.domain.TableItem;
import com.example.bitjumppms.utils.JwtUtils;
import com.example.bitjumppms.utils.ObjTransferUtil;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:5173",maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    DBController db;

    UserController() throws IOException {
        db = new DBController();
    }

    @PutMapping("/{userid}/info")
    //修改特定人的信息
    public BaseResponse putUserInfo(@PathVariable String userid,
                                    @RequestBody MyUser myUser,
                                    HttpServletRequest request){
        String TokenId = JwtUtils.getIdFromRequest(request);

        if(TokenId.equals(userid)){
            log.info("是本人");
            myUser.setUserId(userid);
            User user = ObjTransferUtil.MyUsertoUser(myUser);
            this.db.UpdateUserInfo(user);
        }
        log.info("id = {}",myUser.getUserId());

        return BaseResponse.success();
    }

    @GetMapping("/{userid}/info")
    //获取特定人员信息
    public BaseResponse getUserInfo(@PathVariable String userid,
                                    HttpServletRequest request){
        User user = new User();
        String TokenId = JwtUtils.getIdFromRequest(request);
        user = this.db.SelectUserInfoByID(userid);
//        if(TokenId.equals(userid)){
//            log.info("是本人");
//        }
        return BaseResponse.success(ObjTransferUtil.UserToMyUser(user));
    }



    @GetMapping("/list")
    // 获取所有人员列表
    public BaseResponse getAllUser(@RequestParam(required=false, defaultValue="") String name){

        ArrayList<User> users = (ArrayList<User>) this.db.SelectUserInfoAll();

        return BaseResponse.success(ObjTransferUtil.ListUserToMyUser(users));
    }




    @GetMapping("/schedule")
    //获取日程信息
    public BaseResponse getSchedule(HttpServletRequest request){
        ArrayList<TableItem> tableItems = new ArrayList<>();
        tableItems.add(TableItem.test1());
        tableItems.add(TableItem.test2());

        String userId = JwtUtils.getIdFromRequest(request);
        log.info("userid = {}",userId);

        List<Task> chenxfTask = db.SelectTasksInfoByUserID(userId);
        log.info("in the fuck funnction");
        for(var fuck:chenxfTask){
            log.info(fuck.toString());
        }

        //处理返回值
        HashMap<String,ArrayList<String>> pack = new HashMap<>();
        for(Task t : chenxfTask){
            String name = t.getName();
            String endTime = t.getDueTime();
            //已存在
            if(pack.containsKey(endTime)){
                ArrayList<String> names = pack.get(endTime);
                names.add(name);
                pack.replace(endTime,names);
            }
            //不存在
            else{
                pack.put(endTime, new ArrayList<>(Collections.singleton(name)));
            }
        }
        ArrayList<Schedule> schedules = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : pack.entrySet()) {
            schedules.add(new Schedule(entry.getValue(),entry.getKey()));
        }
        HashMap<String,Object> data = new HashMap<>();
        data.put("schedule",schedules);
        data.put("greeting","Hello world");
        return BaseResponse.success(data);
    }
}
