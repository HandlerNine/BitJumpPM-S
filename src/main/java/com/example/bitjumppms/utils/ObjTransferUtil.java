package com.example.bitjumppms.utils;

import com.chenxf.DB.POJO.Task;
import com.chenxf.DB.POJO.User;
import com.example.bitjumppms.domain.MyUser;
import com.example.bitjumppms.domain.Project;
import com.example.bitjumppms.domain.TableItem;

import java.util.ArrayList;

public class ObjTransferUtil {

    public static MyUser UserToMyUser(User user) {
        MyUser myUser = new MyUser();
        if(!user.equals(null)) {
            myUser.setAddress(user.getAddress());

            if(user.getAge()==null)
                myUser.setAge(-1);
            else
                myUser.setAge(Long.parseLong(user.getAge()));
            myUser.setBirthDate(user.getBirthDate());
            myUser.setBloodType(user.getBloodType());
            myUser.setCensusRegister(user.getCensusRegister());
            myUser.setCreatedProId(null);
            myUser.setDepartment(user.getDepartment());
            myUser.setEducation(user.getEducation());
            myUser.setEmail(user.getEmail());
            myUser.setEntryTime(user.getEntryTime());
            myUser.setGender(user.getGender());
            myUser.setJobTitle(user.getJobTitle());
            myUser.setJoinedProId(null);
            myUser.setLimitation(user.getLimitation());
            myUser.setMajor(user.getMajor());
            myUser.setManagedProId(null);
            myUser.setMarriage(user.getMarriage());
            myUser.setName(user.getName());
            myUser.setNationality(user.getNationality());
            myUser.setPhoneNumber(user.getPhoneNumber());
            myUser.setPhoto(user.getPhotoUrl());
            myUser.setPoliticalStatus(user.getPoliticalStatus());
            myUser.setPost(user.getPost());
            myUser.setPreviousCompany(user.getPreviousCompany());
            if(user.getPriv() == null)
                myUser.setPriv(-1);
            else
                myUser.setPriv((long) user.getPriv());
            myUser.setProjectTeam("工程部");
            myUser.setQqNumber(user.getQQNumber());
            myUser.setSchool(user.getSchool());

            if(user.getSeniority() ==null)
                myUser.setSeniority(-1);
            else
                myUser.setSeniority(Long.parseLong(user.getSeniority()));

            myUser.setUserId(user.getUserID());
            myUser.setWechatNumber(user.getWechatNumber());
        }
        return myUser;
    }

    public static User MyUsertoUser(MyUser user) {
        User u = new User();
        if(!user.equals(null)) {
            u.setUserID(user.getUserId());
            u.setEmail(user.getEmail());
            u.setName(user.getName());
            u.setGender(user.getGender());
            u.setPhoneNumber(user.getPhoneNumber());
            u.setEntryTime(user.getEntryTime());
            u.setDepartment(user.getDepartment());
            u.setPriv((int) user.getPriv());
            u.setEducation(user.getEducation());
            u.setCensusRegister(user.getCensusRegister());
            u.setNationality(user.getNationality());
            u.setMarriage(user.getMarriage());
            u.setBirthDate(user.getBirthDate());
            u.setAge(String.valueOf(user.getAge()));
            u.setBloodType(user.getBloodType());
            u.setPoliticalStatus(user.getPoliticalStatus());
            u.setQQNumber(user.getQqNumber());
            u.setWechatNumber(user.getWechatNumber());
            u.setPost(user.getPost());
            u.setAddress(user.getAddress());
            u.setSchool(user.getSchool());
            u.setMajor(user.getMajor());
            u.setPreviousCompany(user.getPreviousCompany());
            u.setJobTitle(user.getJobTitle());
            u.setLimitation(user.getLimitation());
            u.setPhotoUrl(user.getPhoto());
            u.setSeniority(String.valueOf(user.getSeniority()));
        }
        return u;
    }

    public static ArrayList<MyUser> ListUserToMyUser(ArrayList<User> users){
        ArrayList<MyUser> myUsers = new ArrayList<>();

        if(users!=null)
            for(User u : users)
                myUsers.add(UserToMyUser(u));

        return myUsers;
    }

    public static ArrayList<User> ListMyUserToUser(ArrayList<MyUser> myUsers){
        ArrayList<User> users = new ArrayList<>();
        if(myUsers != null)
            for (MyUser u : myUsers)
                users.add(MyUsertoUser(u));
        return users;
    }


    public static Task TableItemToTask(TableItem tableItem) {
        Task task = new Task();
        if(!tableItem.equals(null)) {
            if(tableItem.getProjectId()!=null)
                task.setProjectID(tableItem.getProjectId());
            task.setTaskID(tableItem.getTableItemId());
            task.setName(tableItem.getTableItemName());
            task.setStartTime(tableItem.getBeginTime());
            task.setDueTime(tableItem.getEndTime());
            task.setEndTime(tableItem.getFinishTime());
            task.setLeaderID(tableItem.getOwnerId());
            task.setFinished(tableItem.isFinish());
            task.setChecked(false);
            task.setRemark(tableItem.getDescription());
        }
        return task;
    }

    public static TableItem TaskToTableItem(Task task) {
        TableItem tableItem = new TableItem();
        if(!task.equals(null)) {
            tableItem.setTableItemName(task.getName());
            tableItem.setTableItemId(task.getProjectID());
            tableItem.setBeginTime(task.getStartTime());
            tableItem.setEndTime(task.getDueTime());
            tableItem.setOwnerId(task.getLeaderID());
            tableItem.setOwnerName(task.getName());
            tableItem.setFinish(task.getFinished());
            tableItem.setFinishTime(task.getEndTime());
            tableItem.setDescription(task.getRemark());
            tableItem.setOwnerId("23");
            tableItem.setOwnerName("2332");
            tableItem.setFinish(false);
            tableItem.setFinishTime("jfjal");
        }
        return tableItem;
    }

    public static ArrayList<Task> ListTableItemToTask(ArrayList<TableItem> tableItems){
        ArrayList<Task> tasks = new ArrayList<>();
        if(tableItems != null)
            for(TableItem t : tableItems)
                tasks.add(TableItemToTask(t));
        return tasks;
    }

    public static ArrayList<TableItem> ListTaskToTableItem(ArrayList<Task> tasks){
        ArrayList<TableItem> tableItems = new ArrayList<>();
        if(tasks!=null)
            for(Task t : tasks)
                tableItems.add(TaskToTableItem(t));
        return tableItems;
    }

    public static Project ToProject(com.chenxf.DB.POJO.Project minPro, ArrayList<Task> tasks, ArrayList<User> users){
        Project project = new Project();
        if(!minPro.equals(null)) {
            project.setProjectId(minPro.getProjectID());
            project.setProjectName(minPro.getName());
            project.setProjectPhoto(minPro.getIconUrl());
            project.setProcess(0);
            project.setDepartment("工程部");
            project.setIntroduction(minPro.getIntro());
            project.setLeaderId(minPro.getMasterID());
            project.setLeaderName(minPro.getMasterName());
            project.setProcess(15);
            project.setBudget(12);
            project.setProjectPhoto("12");
            project.setLeaderName("hfalj");
            project.setProcess(12);
        }
        //表项
        project.setTable(ListTaskToTableItem(tasks));
        //用户列表
        project.setMembers(ListUserToMyUser(users));
        return project;
    }

    public static com.chenxf.DB.POJO.Project ProjectToProjectInfo(Project project){
        com.chenxf.DB.POJO.Project minPro = new com.chenxf.DB.POJO.Project();
        if(!project.equals(null)) {
            minPro.setProjectID(project.getProjectId());
            minPro.setName(project.getProjectName());
            minPro.setIconUrl(project.getProjectPhoto());
            minPro.setIntro(project.getIntroduction());
            minPro.setMasterID(project.getLeaderId());
            minPro.setMasterName(project.getLeaderName());
            minPro.setBudget(String.valueOf(project.getBudget()));
        }
        return minPro;
    }

    public static ArrayList<Task> ProjectToTasks(Project project){
        return ListTableItemToTask(project.getTable());
    }

    public static ArrayList<User> ProjectToUsers(Project project){
        return ListMyUserToUser(project.getMembers());
    }

    public static ArrayList<Project> ListToProject(ArrayList<com.chenxf.DB.POJO.Project> minPro){
        ArrayList<Project> projects = new ArrayList<>();
        for(com.chenxf.DB.POJO.Project p : minPro)
            projects.add(ToProject(p,null,null));
        return projects;
    }

}
