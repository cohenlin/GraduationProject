package com.cohen.scheduletracking.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohen.scheduletracking.common.dao.LoginMapper;
import com.cohen.scheduletracking.common.service.LoginService;
import com.cohen.scheduletracking.entity.Employee;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Employee checkUserName(Employee emp) {
        return loginMapper.checkUserName(emp.getUserName());
    }

    @Override
    public Employee checkPassword(Employee emp) {
        return loginMapper.checkPassword(emp.getUserName(), emp.getPassword());
    }

    @Override
    public Employee checkValid(Employee emp) {
        return loginMapper.checkValid(emp.getUserName(), emp.getPassword(), true);
    }
}
