package com.cohen.scheduletracking.service;

import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.entity.Employee;

import javax.servlet.http.HttpSession;

public interface LoginService {

    MessageBody login(Employee emp, MessageBody msg, HttpSession session);

    Employee login(String username, String password);

    /**
     * 检验权限
     * @param msg
     * @param session
     * @return
     */
    MessageBody checkJurisdiction(MessageBody msg,HttpSession session);
}
