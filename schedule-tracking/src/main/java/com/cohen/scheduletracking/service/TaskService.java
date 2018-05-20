package com.cohen.scheduletracking.service;

import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.entity.Task;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface TaskService {

    /**
     * 新增任务
     *
     * @return
     */
    MessageBody insert(Task task, MessageBody msg, HttpSession session);

    /**
     * 检索当前用户所有任务
     *
     * @return
     */
    List<Task> list(HttpSession session);

    MessageBody listExamine(HttpSession session, MessageBody msg);

    /**
     * 设置任务为已完成
     *
     * @return
     */
    MessageBody changeTaskToFinish(int id, MessageBody msg, HttpSession session);

    /**
     * 通过审核，设置任务为完成
     */
    MessageBody examine(int id, MessageBody msg, HttpSession session);

    /**
     * 回滚任务
     */
    MessageBody rollBack(int id, MessageBody msg, HttpSession session);
    /**
     * 删除当前任务
     *
     * @return
     */
    MessageBody delete(int id, MessageBody msg, HttpSession session);

    /**
     * 编辑任务
     *
     * @return
     */
    MessageBody edit(int id, MessageBody msg, HttpSession session);
}
