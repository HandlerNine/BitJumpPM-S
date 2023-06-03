package com.chenxf.DB.Mapper;

import com.chenxf.DB.POJO.Project;
import com.chenxf.DB.POJO.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectsMapper {

    Project selectByID(@Param("ProjectID") Integer ProjectID);

    List<Integer> selectIDByMaster(@Param("MasterID") String MasterID);

    Integer insert(Project project);

    void deleteByID(@Param("ProjectID") Integer ProjectID);

    int update(Project project);

}
