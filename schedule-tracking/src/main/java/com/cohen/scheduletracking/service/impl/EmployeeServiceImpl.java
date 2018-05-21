package com.cohen.scheduletracking.service.impl;

import com.cohen.redis.assembly.cache.RedisDao;
import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.dao.EmployeeMapper;
import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.service.EmployeeService;
import com.cohen.scheduletracking.utils.MD5Util;
import com.cohen.scheduletracking.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RedisDao redisDao;

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
        return (ids == null || ids.size() == 0) ? new ArrayList<>() : employeeMapper.queryById(ids);
    }

    @Override
    public MessageBody changePassword(Map<String, String> params, MessageBody msg) {
        // 根据username去redis中查code
        String username = params.get("userName");
        String code = params.get("code");
        String[] code_email = ((String) redisDao.get(username)).split("_");// code_email
        if (!(code_email[0].equals(code) || code_email[0] == code)) {// 如果code不一致，返回错误代码
            msg.setStatus("0");
            msg.setBody("修改失败！请重试!");
            redisDao.del(username);// 删除redis中的code信息
            return msg;
        }
        // code一致, 以username、email为参数修改密码
        params.put("username", params.get("userName"));
        params.put("email", code_email[1]);
        params.put("password", MD5Util.MD5(params.get("passWord")));// 先用MD5进行密码加密
        if (employeeMapper.changePassword(params) == 1) {// 修改密码
            msg.setStatus("1");
            msg.setBody("修改成功！");
        } else {
            msg.setStatus("0");
            msg.setBody("修改失败！请重试!");
        }
        redisDao.del(username);// 删除redis中的code信息
        return msg;
    }
}
