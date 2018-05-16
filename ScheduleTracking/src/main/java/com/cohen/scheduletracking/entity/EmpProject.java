package com.cohen.scheduletracking.entity;

import java.io.Serializable;

/**
 * 员工与项目中间类
 */
public class EmpProject implements Serializable {

    private int id;
    private int empId;// 员工ID
    private int proId;// 项目ID
    private String manager;// 是否为管理者

    public int getId() {
        return id;
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

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
