package com.cohen.scheduletracking.leader.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.leader.dao.EmployeeMapper;
import com.cohen.scheduletracking.leader.service.EmployeeService;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployeeByDeptId(int deptId) {
        return employeeMapper.getEmployeeByDeptId(deptId);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }

}
