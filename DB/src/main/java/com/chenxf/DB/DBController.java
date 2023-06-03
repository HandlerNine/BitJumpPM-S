package com.chenxf.DB;

import com.chenxf.DB.Mapper.CrewsMapper;
import com.chenxf.DB.Mapper.ProjectsMapper;
import com.chenxf.DB.Mapper.TasksMapper;
import com.chenxf.DB.Mapper.UsersMapper;
import com.chenxf.DB.POJO.Project;
import com.chenxf.DB.POJO.Task;
import com.chenxf.DB.POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DBController {
    SqlSessionFactory sqlSessionFactory;
    public DBController() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    // select single user's name
    public String SelectUserNameByID(String UserID) {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

        String Name = usersMapper.selectNameByID(UserID);

        sqlSession.close();

        return Name;
    }

    // select single user's info
    public User SelectUserInfoByID(String UserID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

        User user = usersMapper.selectByID(UserID);

        sqlSession.close();

        return user;
    }

    // select single group's info
    public Project SelectProjectInfo(int projectID){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ProjectsMapper projectsMapper = sqlSession.getMapper(ProjectsMapper.class);

        Project projectInfo = projectsMapper.selectByID(projectID);

        sqlSession.close();

        return projectInfo;
    }


    // select group projects' info
    public List<Project> SelectProjectsInfo(int type,String UserID) {
        List<Integer> projectsID=null;
        List<Project> projectsInfo = new ArrayList<Project>();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        ProjectsMapper projectsMapper = sqlSession.getMapper(ProjectsMapper.class);
        CrewsMapper crewsMapper = sqlSession.getMapper(CrewsMapper.class);

        // get projects ID for select
        switch (type){
            case 0:
                projectsID = projectsMapper.selectIDByMaster(UserID);
                break;
            case 1:
                projectsID = crewsMapper.selectProjectIDByManager(UserID);
                break;
            case 2:
                projectsID = crewsMapper.selectProjectIDByMember(UserID);
                break;
            default:
                projectsID = null;
        }
        if (projectsID==null) {
            System.out.println("ERROR: SelectProject() unknown type");
            return null;
        }

        // select information about projects
        for(var projectID : projectsID) {
            Project projectInfo = SelectProjectInfo(projectID);

            String MasterName = SelectUserNameByID(projectInfo.getMasterID());

            projectInfo.setMasterName(MasterName);
            projectsInfo.add(projectInfo);
        }

        sqlSession.close();
        System.out.println("Success: SelectProject()");

        return projectsInfo;
    }

    // select project's members' info
    public List<User> SelectProjectMemberInfo(int projectID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        CrewsMapper crewsMapper = sqlSession.getMapper(CrewsMapper.class);

        List<String> membersID = crewsMapper.selectProjectMemberID(projectID);

        List<User> membersInfo = new ArrayList<User>();
        for(String memberID:membersID){
            User memberInfo = SelectUserInfoByID(memberID);
            membersInfo.add(memberInfo);
        }

        sqlSession.close();

        return membersInfo;
    }

    // select single task's info by ID
    public Task SelectTasksInfoByID(int taskID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        Task taskInfo = tasksMapper.selectInfoByID(taskID);

        sqlSession.close();

        return taskInfo;
    }


    // select project's tasks' info
    public List<Task> SelectProjectTasksInfo(int projectID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        List<Task> tasksInfo = tasksMapper.selectInfoByProjectID(projectID);

        sqlSession.close();

        return tasksInfo;
    }

    // select user's tasks' info
    public List<Task> SelectUserTasksInfo(String UserID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        List<Task> tasksInfo = tasksMapper.selectInfoByUserID(UserID);

        sqlSession.close();

        return tasksInfo;
    }
}
