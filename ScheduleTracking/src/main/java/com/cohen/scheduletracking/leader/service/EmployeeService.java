package com.cohen.scheduletracking.leader.service;

import java.util.List;

import com.cohen.scheduletracking.entity.Employee;

/**
 * 员工信息相关业务
 * 
 * @author 林金成
 *         2018年4月6日
 */
public interface EmployeeService {

    /**
     * 根据部门查出所有员工
     */
    List<Employee> getEmployeeByDeptId(int deptId);

    /**
     * 根据id查员工
     * 
     * @return
     */
    Employee getEmployeeById(int id);
}
