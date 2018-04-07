package com.cohen.scheduletracking.leader.dao;

import java.util.List;

import com.cohen.scheduletracking.entity.Department;

/**
 * 部门信息mapper
 * 
 * @author 林金成
 *         2018年4月6日
 */
public interface DepartmentMapper {

    /**
     * 查询所有的部门信息
     */
    List<Department> getAllDepartment();
}
