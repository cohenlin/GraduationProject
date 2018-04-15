package com.cohen.scheduletracking.common.controller;

import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.common.service.TaskService;
import com.cohen.scheduletracking.entity.Task;
import com.cohen.scheduletracking.utils.DateEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
     * 传参时将字符串日期转换为date对象
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    /**
     * 新增任务
     *
     * @param task
     * @param msg
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public MessageBody insert(Task task, HttpSession session, MessageBody msg) {
        return taskService.insert(task, msg, session);
    }

    /**
     * 检索当前用户所有相关任务
     *
     * @return
     */
    @RequestMapping(value = "listAllUnFinished", method = RequestMethod.GET)
    public List<Task> listAllUnFinished(HttpSession session) {
        return taskService.list(session, "0");
    }

    @RequestMapping(value = "listAllFinished", method = RequestMethod.GET)
    public List<Task> listAllFinished(HttpSession session) {
        return taskService.list(session, "1");
    }

    @RequestMapping(value = "finish", method = RequestMethod.PUT)
    public MessageBody changeTaskToFinish(@RequestParam("id") int id, MessageBody msg) {
        return taskService.changeTaskToFinish(id, msg);
    }

}
