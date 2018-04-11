package com.cohen.scheduletracking.common.service;

import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.entity.Task;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface TaskService {

    /**
     * 新增任务
     * @param task
     * @param msg
     * @return
     */
    MessageBody insert(Task task, MessageBody msg, HttpSession session);

    List<Task> list(HttpSession session);
}
