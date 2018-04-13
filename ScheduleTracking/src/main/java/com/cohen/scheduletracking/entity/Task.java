package com.cohen.scheduletracking.entity;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private int id;// 主键
    private String taskInfo;// 任务信息
    private Date beginTime;// 开始时间
    private Date estimatedTime;// 预计完成时间
    private Date endTime;// 完成时间
    private int empId;// 员工id
    private int managerId;// 领导
    private int projectId;// 所属项目
    private double schedule;// 进度
    private String finish;// 是否完成
    private String delete;// 是否删除

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public void setEstimatedTime(Date estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setSchedule(double schedule) {
        this.schedule = schedule;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public Date getEstimatedTime() {
        return estimatedTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public double getSchedule() {
        return schedule;
    }

    public String isFinish() {
        return finish;
    }

    public String isDelete() {
        return delete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
