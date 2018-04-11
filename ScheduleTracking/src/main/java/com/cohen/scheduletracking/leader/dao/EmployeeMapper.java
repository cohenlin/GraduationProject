package com.cohen.scheduletracking.leader.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cohen.scheduletracking.entity.Employee;

/**
 * 员工信息的mapper
 * 
 * @author 林金成
 *         2018年4月6日
 */
public interface EmployeeMapper {

    /**
     * 根据部门查员工
     */
    List<Employee> getEmployeeByDeptId(@Param("deptId") int deptId);

    /**
     * 根据id查员工
     */
    Employee getEmployeeById(int id);
}
