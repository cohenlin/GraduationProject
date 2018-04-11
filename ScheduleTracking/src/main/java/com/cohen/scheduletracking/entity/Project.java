package com.cohen.scheduletracking.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

/**
 * 封装项目信息的实体类
 * 
 * @author 林金成
 *         2018年4月3日
 */
@Validated
public class Project implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5453892726028890877L;

    private int id;// 主键
    @NotBlank(message = "项目名不能为空！")
    private String projectName;// 项目名
    private int deptId;// 所属部门主键
    @Past(message = "应早于当前时间！")
    private Date beginTime;// 项目开始时间
    @Future(message = "应晚于当前时间！")
    private Date expectEndTime;// 预计结束时间
    private Date endTime;
    @Min(value = 0, message = "预算不能小于0！")
    private double budget;// 预算经费（元）
    private int managerId;// 负责人主键
    @NotBlank(message = "描述不能为空！")
    private String projectDescribe;// 项目简介
    @NotBlank(message = "请提交策划案！")
    private String schemeFile;// 项目策划文件
    private double schedule;// 当前进度
    private boolean finished;// 是否完成
    private int createUser;// 创建人
    private Date createTime;// 创建时间
    private int updateUser;// 修改人
    private Date updateTime;// 修改时间
    private boolean deleted;// 逻辑删除

    @Override
    public String toString() {
        return "Project [projectName=" + projectName + ", deptId=" + deptId + ", beginTime=" + beginTime
                + ", expectEndTime=" + expectEndTime + ", budget=" + budget + ", managerId=" + managerId
                + ", projectDescribe=" + projectDescribe + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getProjectDescribe() {
        return projectDescribe;
    }

    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe;
    }

    public String getSchemeFile() {
        return schemeFile;
    }

    public void setSchemeFile(String schemeFile) {
        this.schemeFile = schemeFile;
    }

    public double getSchedule() {
        return schedule;
    }

    public void setSchedule(double schedule) {
        this.schedule = schedule;
    }

    public int getCreateUser() {
        return createUser;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(int updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
