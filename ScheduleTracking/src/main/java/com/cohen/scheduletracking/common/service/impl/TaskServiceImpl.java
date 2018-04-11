package com.cohen.scheduletracking.common.service.impl;

import com.cohen.scheduletracking.common.dao.TaskMapper;
import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.common.service.TaskService;
import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public MessageBody insert(Task task, MessageBody msg, HttpSession session) {
        Employee user = (Employee) session.getAttribute("user");
        task.setEmpId(user.getId());// 用户自己新增任务,managerId和empId都是自己
        task.setManagerId(user.getId());
        task.setBeginTime(new Date());
        task.setFinish(false);
        task.setDelete(false);
        if (taskMapper.insert(task) == 1) {
            msg.setStatus("1");
        } else {
            msg.setStatus("0");
        }
        return msg;
    }

    @Override
    public List<Task> list(HttpSession session) {
        Employee emp = (Employee) session.getAttribute("user");
        return taskMapper.list(emp.getId());
    }
}
