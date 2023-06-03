package com.chenxf.DB.Mapper;

import com.chenxf.DB.POJO.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TasksMapper {
    Task selectInfoByID(@Param("TaskID")Integer TaskID);

    List<Task> selectInfoByProjectID(@Param("ProjectID") Integer ProjectID);

    List<Task> selectInfoByUserID(@Param("LeaderID") String UserID);

    Integer insert(Task task);

    int update(Task task);
}
