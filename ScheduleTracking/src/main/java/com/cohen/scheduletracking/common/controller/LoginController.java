package com.cohen.scheduletracking.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.common.service.LoginService;
import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.utils.MD5Util;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public MessageBody login(Employee emp, HttpSession session, MessageBody msg) {
        if (emp != null) {
            if (emp.getUserName() != null && emp.getUserName() != "") {
                if (emp.getPassword() != null && emp.getPassword() != "") {
                    Employee empResult = loginService.checkUserName(emp);
                    if (empResult != null && empResult.getId() > 0) {
                        String password = emp.getPassword();
                        emp.setPassword(MD5Util.MD5(emp.getPassword()));
                        empResult = loginService.checkPassword(emp);
                        emp.setPassword(password);
                        if (empResult != null && empResult.getId() > 0) {
                            emp.setPassword(MD5Util.MD5(emp.getPassword()));
                            empResult = loginService.checkValid(emp);
                            if (empResult != null && empResult.getId() > 0) {
                                msg.setStatus("1");
                                msg.setBody("登陆成功！");
                                emp.setPassword(null);
                                session.setAttribute("user", emp);
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
