package com.cohen.scheduletracking.leader.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cohen.scheduletracking.entity.Department;
import com.cohen.scheduletracking.leader.service.DepartmentService;

@Controller
@RequestMapping("/dept")
public class DepartmentController {

    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有部门信息，返回json
     */
    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Department> getAllDepartments() {
        logger.info("查询到所有部门信息，返回json");
        return departmentService.getAllDepartment();
    }
}
