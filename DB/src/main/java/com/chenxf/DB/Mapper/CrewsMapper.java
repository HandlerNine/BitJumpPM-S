package com.chenxf.DB.Mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrewsMapper {

    List<Integer> selectProjectIDByManager(@Param("UserID") String userID);

    List<Integer> selectProjectIDByMember(@Param("UserID") String userID);


    //select all member's UserID but do not concern is manager or not
    List<String> selectMemberIDByProject(@Param("ProjectID") Integer ProjectID);

//    List<String>
    void insert(@Param("ProjectID") Integer ProjectID,@Param("UserID") String userID);

    int update(@Param("ProjectID") Integer ProjectID,@Param("UserID") String userID,@Param("IsManager") int IsManager);

    void delete(@Param("ProjectID") Integer ProjectID,@Param("UserID") String userID);
}
