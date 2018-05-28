package com.cohen.scheduletracking.controller;

import com.cohen.scheduletracking.entity.MessageBody;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu")
public class ViewController {

    @ExceptionHandler(value = {ShiroException.class})
    public String exceptionHandler(Exception e) {
        if(e instanceof AuthorizationException){
            return "403";
        }
        if(e instanceof AuthenticationException){
            return "redirect:logout";
        }
        return "500";
    }

    @RequiresRoles(value = {"2","3"}, logical = Logical.OR)
    @RequestMapping("project/add")
    public String addProject() {
        return "add_project";
    }

    @RequiresRoles(value = {"1","2","3"}, logical = Logical.OR)
    @RequestMapping("project/list")
    public String listProject() {
        return "index";
    }

    @RequiresRoles(value = {"1","2","3"}, logical = Logical.OR)
    @RequestMapping("task/list")
    public String listTask() {
        return "todo_list";
    }

    @RequiresRoles(value = {"2","3"}, logical = Logical.OR)
    @RequestMapping("task/listExamine")
    public String listExamineTask() {
        return "task_examine_list";
    }

    @RequiresRoles(value = {"2","3"}, logical = Logical.OR)
    @RequestMapping("project/listExamine")
    public String listExamineProject() {
        return "project_examine_list";
    }
}
