package com.cohen.scheduletracking.entity;

import java.io.Serializable;

/**
 * 部门信息实体类
 * 
 * @author 林金成
 *         2018年4月6日
 */
public class Department implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2657441927286172718L;

    private int id;// 部门编号
    private String deptName;// 部门名称
    private int deptManager;// 部门领导

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptManager() {
        return deptManager;
    }

    public void setDeptManager(int deptManager) {
        this.deptManager = deptManager;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", deptName=" + deptName + ", deptManager=" + deptManager + "]";
    }
}