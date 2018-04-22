package com.cohen.scheduletracking.service.impl;

import com.cohen.scheduletracking.dao.DepartmentMapper;
import com.cohen.scheduletracking.entity.Department;
import com.cohen.scheduletracking.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
