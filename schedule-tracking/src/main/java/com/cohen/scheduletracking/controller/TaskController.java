package com.cohen.scheduletracking.controller;

import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.service.TaskService;
import com.cohen.scheduletracking.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 任务相关
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 任务列表内新增任务，默认为个人任务
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public MessageBody insert(Task task, HttpSession session, MessageBody msg) {
        return taskService.insert(task, msg, session);
    }

    /**
     * 检索当前用户所有相关任务
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Task> list(HttpSession session) {
        return taskService.list(session);
    }

    /**
     * 检索需要当前用户审核的任务
     */
    @RequestMapping(value = "listExamine", method = RequestMethod.GET)
    public MessageBody listExamine(HttpSession session, MessageBody msg) {
        return taskService.listExamine(session, msg);
    }

    /**
     * 将当前任务设置为完成，若为个人任务，直接设置为完成，若为项目任务，则进入审核状态
     */
    @RequestMapping(value = "finish", method = RequestMethod.PUT)
    public MessageBody changeTaskToFinish(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return taskService.changeTaskToFinish(id, msg, session);
    }

    /**
     * 通过审核，设置任务为完成
     */
    @RequestMapping(value = "examine", method = RequestMethod.PUT)
    public MessageBody examine(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return taskService.examine(id, msg, session);
    }

    @RequestMapping(value = "rollBack", method = RequestMethod.PUT)
    public MessageBody rollBack(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return taskService.rollBack(id, msg, session);
    }

    /**
     * 点击删除任务按钮，认证用户权限，若通过则删除，否则提示权限不足
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public MessageBody delete(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return taskService.delete(id, msg, session);
    }

    /**
     * 修改任务信息
     */
    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    public MessageBody edit(@RequestParam("id") int id, MessageBody msg, HttpSession session) {
        return taskService.edit(id, msg, session);
    }
}
