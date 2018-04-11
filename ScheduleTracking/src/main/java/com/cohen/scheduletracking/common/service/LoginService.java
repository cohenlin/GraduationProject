package com.cohen.scheduletracking.common.service;

import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.entity.Employee;

import javax.servlet.http.HttpSession;

public interface LoginService {

    MessageBody login(Employee emp, MessageBody msg, HttpSession session);
}
