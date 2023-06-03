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
    public Project SelectProjectInfoByID(int projectID){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ProjectsMapper projectsMapper = sqlSession.getMapper(ProjectsMapper.class);

        Project projectInfo = projectsMapper.selectByID(projectID);

        sqlSession.close();

        return projectInfo;
    }

    // select group projects' info
    public List<Project> SelectProjectsInfoByUserID(int type,String UserID) {
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
            Project projectInfo = SelectProjectInfoByID(projectID);

            String MasterName = SelectUserNameByID(projectInfo.getMasterID());

            projectInfo.setMasterName(MasterName);
            projectsInfo.add(projectInfo);
        }

        sqlSession.close();
        System.out.println("Success: SelectProject()");

        return projectsInfo;
    }

    // select project's members' info
    public List<User> SelectProjectMemberInfoByProjectID(int projectID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        CrewsMapper crewsMapper = sqlSession.getMapper(CrewsMapper.class);

        List<String> membersID = crewsMapper.selectMemberIDByProject(projectID);

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
    public List<Task> SelectTasksInfoByProjectID(int projectID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        List<Task> tasksInfo = tasksMapper.selectInfoByProjectID(projectID);

        sqlSession.close();

        return tasksInfo;
    }

    // select user's tasks' info
    public List<Task> SelectTasksInfoByUserID(String UserID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        List<Task> tasksInfo = tasksMapper.selectInfoByUserID(UserID);

        sqlSession.close();

        return tasksInfo;
    }

    public String InsertUser(String UserID,String Password,String Email){
        User user=new User();
        user.setUserID(UserID);
        user.setPassword(Password);
        user.setEmail(Email);

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

        String ID = usersMapper.insert(user);

        sqlSession.commit();
        sqlSession.close();

        return ID;
    }

    public int UpdateUserPassword(String UserID,String Password){
        User user=new User();
        user.setUserID(UserID);
        user.setPassword(Password);

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

        int status = usersMapper.update(user);

        sqlSession.commit();
        sqlSession.close();

        return status;
    }

    public int UpdateUserInfo(User user){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

        int status = usersMapper.update(user);

        sqlSession.commit();
        sqlSession.close();

        return status;
    }

    public Integer InsertProject(Project project){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        ProjectsMapper projectsMapper = sqlSession.getMapper(ProjectsMapper.class);

        Integer ProjectID = projectsMapper.insert(project);

        sqlSession.commit();
        sqlSession.close();

        return ProjectID;
    }

    public void DeleteProjectByID(Integer ProjectID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        ProjectsMapper projectsMapper = sqlSession.getMapper(ProjectsMapper.class);

        projectsMapper.deleteByID(ProjectID);

        sqlSession.commit();
        sqlSession.close();

        return;
    }

    public int UpdateProjectInfo(Project project){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        ProjectsMapper projectsMapper = sqlSession.getMapper(ProjectsMapper.class);

        int status = projectsMapper.update(project);

        sqlSession.commit();
        sqlSession.close();

        return status;
    }

    public Integer InsertTask(Task task){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        Integer TaskID = tasksMapper.insert(task);

        sqlSession.commit();
        sqlSession.close();

        return TaskID;
    }

    public int UpdateTaskInfo(Task task){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        Integer TaskID = tasksMapper.update(task);

        sqlSession.commit();
        sqlSession.close();

        return TaskID;
    }

    public int CommitTask(Task task){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        Integer TaskID = tasksMapper.update(task);

        sqlSession.commit();
        sqlSession.close();

        return TaskID;
    }

    public int CheckTask(Task task){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        TasksMapper tasksMapper = sqlSession.getMapper(TasksMapper.class);

        Integer TaskID = tasksMapper.update(task);

        sqlSession.commit();
        sqlSession.close();

        return TaskID;
    }

    public void InsertCrew(Integer ProjectID,String UserID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        CrewsMapper crewsMapper = sqlSession.getMapper(CrewsMapper.class);

        crewsMapper.insert(ProjectID,UserID);

        sqlSession.commit();
        sqlSession.close();

        return;
    }
    public void DeleteCrew(Integer ProjectID,String UserID){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        CrewsMapper crewsMapper = sqlSession.getMapper(CrewsMapper.class);

        crewsMapper.delete(ProjectID,UserID);

        sqlSession.commit();
        sqlSession.close();

        return;
    }
    public void UpdateCrewPriv(Integer ProjectID,String UserID,boolean IsManager){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        CrewsMapper crewsMapper = sqlSession.getMapper(CrewsMapper.class);

        crewsMapper.update(ProjectID,UserID,IsManager?1:0);

        sqlSession.commit();
        sqlSession.close();

        return;
    }
}
