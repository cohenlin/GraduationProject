package com.cohen.scheduletracking.service.impl;

import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.dao.EmployeeMapper;
import com.cohen.scheduletracking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Employee> queryById(List<Integer> ids) {
        return (ids == null || ids.size()  == 0) ? new ArrayList<>() : employeeMapper.queryById(ids);
    }
}
