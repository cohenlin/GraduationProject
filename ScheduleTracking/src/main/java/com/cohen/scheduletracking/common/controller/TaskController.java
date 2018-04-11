package com.cohen.scheduletracking.common.controller;

import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.common.service.TaskService;
import com.cohen.scheduletracking.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 任务相关
 */
@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 新增任务
     * @param task
     * @param msg
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public MessageBody insert(Task task, MessageBody msg, HttpSession session) {
        return taskService.insert(task, msg, session);
    }

    /**
     * 检索当前用户所有相关任务
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Task> list(HttpSession session){
        return taskService.list(session);
    }
}
