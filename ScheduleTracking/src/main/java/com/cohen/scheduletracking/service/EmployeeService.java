package com.cohen.scheduletracking.service;

import com.cohen.scheduletracking.entity.Employee;

import java.util.List;

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

    /**
     * 根据id批量查员工
     * @return
     */
    List<Employee> queryById(List<Integer> ids);
}
