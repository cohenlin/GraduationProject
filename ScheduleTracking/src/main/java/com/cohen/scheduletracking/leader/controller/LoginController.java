package com.cohen.scheduletracking.leader.controller;

import com.cohen.scheduletracking.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author 林金成
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public String login(Employee employee, Map<String, String> map) {
        System.out.println(employee.getUserName() + " || " + employee.getPassword());
        return "index";
    }
}