package com.chenxf.DB.POJO;

public class Task {
    private Integer ProjectID;
    private Integer TaskID;
    private String Name;
    private String StartTime;
    private String DueTime;
    private String EndTime;
    private String LeaderID;
    private Boolean IsFinished;
    private Boolean IsChecked;
    private String Remark;

    public Task(){}

    public Task(Integer projectID, Integer taskID, String name, String startTime, String dueTime, String endTime, String leaderID, Boolean isFinished, Boolean isChecked, String remark) {
        this.ProjectID = projectID;
        this.TaskID = taskID;
        this.Name = name;
        this.StartTime = startTime;
        this.DueTime = dueTime;
        this.EndTime = endTime;
        this.LeaderID = leaderID;
        this.IsFinished = isFinished;
        this.IsChecked = isChecked;
        this.Remark = remark;
    }

    public Integer getProjectID() {
        return ProjectID;
    }

    public void setProjectID(Integer projectID) {
        ProjectID = projectID;
    }

    public Integer getTaskID() {
        return TaskID;
    }

    public void setTaskID(Integer taskID) {
        TaskID = taskID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getDueTime() {
        return DueTime;
    }

    public void setDueTime(String dueTime) {
        DueTime = dueTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getLeaderID() {
        return LeaderID;
    }

    public void setLeaderID(String leaderID) {
        LeaderID = leaderID;
    }

    public Boolean getFinished() {
        return IsFinished;
    }

    public void setFinished(Boolean finished) {
        IsFinished = finished;
    }

    public Boolean getChecked() {
        return IsChecked;
    }

    public void setChecked(Boolean checked) {
        IsChecked = checked;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ProjectID=" + ProjectID +
                ", TaskID=" + TaskID +
                ", Name='" + Name + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", DueTime='" + DueTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", LeaderID='" + LeaderID + '\'' +
                ", IsFinished=" + IsFinished +
                ", IsChecked=" + IsChecked +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}
