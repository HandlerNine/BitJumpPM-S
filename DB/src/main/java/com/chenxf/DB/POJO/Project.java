package com.chenxf.DB.POJO;

public class Project {
    private  Integer ProjectID;
    private  String Name;
    private  String IconUrl;
    private  String Intro;
    private  String MasterID;
    private  String Budget;
    private  String MasterName;

    public Project(){}

    public Project(Integer projectID, String name, String iconUrl, String intro, String masterID, String budget) {
        this.ProjectID = projectID;
        this.Name = name;
        this.IconUrl = iconUrl;
        this.Intro = intro;
        this.MasterID = masterID;
        this.Budget = budget;
    }

    public Integer getProjectID() {
        return ProjectID;
    }

    public void setProjectID(Integer projectID) {
        ProjectID = projectID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIconUrl() {
        return IconUrl;
    }

    public void setIconUrl(String iconUrl) {
        IconUrl = iconUrl;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    public String getMasterID() {
        return MasterID;
    }

    public void setMasterID(String masterID) {
        MasterID = masterID;
    }

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }

    public String getMasterName() {
        return MasterName;
    }

    public void setMasterName(String masterName) {
        MasterName = masterName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ProjectID=" + ProjectID +
                ", Name='" + Name + '\'' +
                ", IconUrl='" + IconUrl + '\'' +
                ", Intro='" + Intro + '\'' +
                ", MasterID='" + MasterID + '\'' +
                ", Budget='" + Budget + '\'' +
                ", MasterName='" + MasterName + '\'' +
                '}';
    }
}
