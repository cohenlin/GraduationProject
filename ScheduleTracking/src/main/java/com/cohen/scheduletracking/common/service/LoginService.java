package com.cohen.scheduletracking.common.service;

import com.cohen.scheduletracking.entity.Employee;

public interface LoginService {
    Employee checkUserName(Employee emp);

    Employee checkPassword(Employee emp);

    Employee checkValid(Employee emp);
}
