package com.cohen.scheduletracking.entity;

import java.util.Date;

/**
 * 封装项目信息的实体类
 * 
 * @author 林金成
 *         2018年4月3日
 */
public class Project {
    private Integer id;// 主键
    private String projectName;// 项目名
    private Integer deptId;// 所属部门主键
    //    private Date beginTime;// 项目开始时间
    //    private Date expectEndTime;// 预计结束时间
    private String beginTime;// 项目开始时间
    private String expectEndTime;// 预计结束时间
    private Double budget;// 预算经费（元）
    private Integer managerId;// 负责人主键
    private String projectDescribe;// 项目简介
    private Double schedule;// 当前进度
    private Boolean isFinish;// 是否完成
    private Integer createUser;// 创建人
    private Date createTime;// 创建时间
    private Integer updateUser;// 修改人
    private Date updateTime;// 修改时间
    private Boolean isDelete;// 逻辑删除

    @Override
    public String toString() {
        return "Project [projectName=" + projectName + ", deptId=" + deptId + ", beginTime=" + beginTime
                + ", expectEndTime=" + expectEndTime + ", budget=" + budget + ", managerId=" + managerId
                + ", projectDescribe=" + projectDescribe + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(String expectEndTime) {
        this.expectEndTime = expectEndTime;
    }
    //    public Date getBeginTime() {
    //        return beginTime;
    //    }
    //    
    //    public void setBeginTime(Date beginTime) {
    //        this.beginTime = beginTime;
    //    }
    //    
    //    public Date getExpectEndTime() {
    //        return expectEndTime;
    //    }
    //    
    //    public void setExpectEndTime(Date expectEndTime) {
    //        this.expectEndTime = expectEndTime;
    //    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Double getSchedule() {
        return schedule;
    }

    public void setSchedule(Double schedule) {
        this.schedule = schedule;
    }

    public Boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getProjectDescribe() {
        return projectDescribe;
    }

    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe;
    }
}
