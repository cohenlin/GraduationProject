package com.cohen.scheduletracking.controller;

import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.service.EmailService;
import com.cohen.scheduletracking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private EmailService emailService;

    @RequestMapping("index")
    public String index() {
        return "index";
    }

//    @ResponseBody
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public MessageBody login(Employee emp, HttpSession session, MessageBody msg) {
//        return loginService.login(emp, msg, session);
//    }

    @RequestMapping(value = "login")
    public String login(Employee emp, HttpSession session, MessageBody msg) {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public MessageBody logout(HttpSession session, MessageBody msg) {
        System.out.println("logout");
        session.setAttribute("user", null);
        msg.setStatus("1");
        msg.setBody("已退出登录！");
        return msg;
    }

    /**
     * 点击找回密码发送邮件
     */
    @ResponseBody
    @RequestMapping(value = "findPassword", method = RequestMethod.POST)
    public MessageBody findPassword(@RequestParam("email") String email, @RequestParam("userName") String userName, MessageBody msg) {
        return emailService.sendUrlForPasswordChange(email, userName, msg);
    }

    @RequestMapping("403")
    public String unauthorized() {
        return "403";
    }

    @RequestMapping(value = "checkJurisdiction", method = RequestMethod.GET)
    public MessageBody checkJurisdiction(MessageBody msg, HttpSession session) {
        return null;
    }
}
