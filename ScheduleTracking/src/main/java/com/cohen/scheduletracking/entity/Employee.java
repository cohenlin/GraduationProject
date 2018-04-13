package com.cohen.scheduletracking.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工信息实体类
 * 
 * @author 林金成
 *         2018年4月6日
 */
public class Employee implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7426098592568199403L;

    private int id;// 员工编号
    private String name;// 员工姓名
    private int gender;// 员工性别（0:女 | 1:男）
    private int age;// 员工年龄
    private int deptId;// 所属部门
    private String post;// 员工职务
    private int level;// 员工等级
    private String phoneNum;// 员工电话
    private String userName;// 员工登录用户名
    private String password;// 员工登录密码
    private String valid;// 该员工是否可用
    private int createUser;// 创建人
    private Date createTime;// 创建时间
    private int updateUser;// 修改人
    private Date updateTime;// 修改时间
    private String deleted;// 逻辑删除

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
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

    public String isDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", deptId=" + deptId
                + ", post=" + post + ", level=" + level + ", phoneNum=" + phoneNum + ", userName=" + userName
                + ", password=" + password + ", valid=" + valid + "]";
    }
}
