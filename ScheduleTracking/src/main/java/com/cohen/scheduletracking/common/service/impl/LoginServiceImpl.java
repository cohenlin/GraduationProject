package com.cohen.scheduletracking.common.service.impl;

import com.cohen.scheduletracking.common.dao.LoginInMapper;
import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.common.service.LoginService;
import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginInMapper loginInMapper;

    public MessageBody login(Employee emp, MessageBody msg, HttpSession session) throws RuntimeException {
        if (emp != null) {
            if (emp.getUserName() != null && emp.getUserName() != "") {
                if (emp.getPassword() != null && emp.getPassword() != "") {
                    Employee empResult = loginInMapper.checkUserName(emp.getUserName());
                    if (empResult != null && empResult.getId() > 0) {
                        String password = emp.getPassword();
                        emp.setPassword(MD5Util.MD5(emp.getPassword()));
                        empResult = loginInMapper.checkPassword(emp.getUserName(), emp.getPassword());
                        emp.setPassword(password);
                        if (empResult != null && empResult.getId() > 0) {
                            emp.setPassword(MD5Util.MD5(emp.getPassword()));
                            empResult = loginInMapper.checkValid(emp.getUserName(), emp.getPassword(), "1");
                            if (empResult != null && empResult.getId() > 0) {
                                msg.setStatus("1");
                                msg.setBody("登陆成功！");
                                empResult.setPassword(null);
                                session.setAttribute("user", empResult);
                                return msg;
                            } else {
                                msg.setStatus("-3");
                                msg.setBody("该用户已被禁止登陆！请联系管理员！");
                                return msg;
                            }
                        } else {
                            msg.setStatus("-2");
                            msg.setBody("密码不正确！");
                            return msg;
                        }
                    } else {
                        msg.setStatus("-1");
                        msg.setBody("用户名不存在！");
                        return msg;
                    }
                } else {
                    msg.setStatus("-2");
                    msg.setBody("密码不能为空！");
                    return msg;
                }
            } else {
                msg.setStatus("-1");
                msg.setBody("用户名不能为空！");
                return msg;
            }
        } else {
            throw new RuntimeException(this.getClass().getTypeName() + " throw an exception!");
        }
    }
}
