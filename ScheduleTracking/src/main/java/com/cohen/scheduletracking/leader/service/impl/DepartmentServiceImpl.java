package com.cohen.scheduletracking.leader.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohen.scheduletracking.entity.Department;
import com.cohen.scheduletracking.leader.dao.DepartmentMapper;
import com.cohen.scheduletracking.leader.service.DepartmentService;

@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }

}
