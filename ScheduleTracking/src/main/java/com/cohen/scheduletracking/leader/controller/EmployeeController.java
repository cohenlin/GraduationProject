package com.cohen.scheduletracking.leader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.leader.service.EmployeeService;

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
}
