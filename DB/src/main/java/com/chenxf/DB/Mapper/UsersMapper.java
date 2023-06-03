package com.chenxf.DB.Mapper;

import com.chenxf.DB.POJO.User;
import com.chenxf.DB.POJO.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    List<User> selectAll();
    User selectByID(@Param("UserID") String UserID);

    String selectNameByID(@Param("UserID") String UserID);

    String selectPasswordByID(@Param("UserID") String UserID);

    String insert(User user);

    int update(User user);

}
