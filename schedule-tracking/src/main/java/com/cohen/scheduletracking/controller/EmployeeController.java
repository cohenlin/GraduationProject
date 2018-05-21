package com.cohen.scheduletracking.controller;

import java.util.List;
import java.util.Map;

import com.cohen.scheduletracking.entity.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.service.EmployeeService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/getByDeptId", method = RequestMethod.GET)
    public List<Employee> getEmployeeByDeptId(@RequestParam("deptId") int deptId) {
        return employeeService.getEmployeeByDeptId(deptId);
    }

    @ResponseBody
    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
    public MessageBody changePassword(@RequestParam Map<String, String> map, MessageBody msg) {
        return employeeService.changePassword(map, msg);
    }
}
