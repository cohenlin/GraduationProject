package com.cohen.scheduletracking.leader.service;

import com.cohen.scheduletracking.common.entity.MessageBody;
import com.cohen.scheduletracking.entity.Project;

import javax.servlet.http.HttpSession;

/**
 * 项目管理的业务类
 * 
 * @author 林金成
 *         2018年4月5日
 */
public interface ProjectService {

    /**
     * 保存项目信息
     * 
     * @return 影响行数
     */
    Integer save(Project project);

    MessageBody list(MessageBody msg, HttpSession session);

    /**
     * 查询项目参与员工
     * @param pid
     * @param msg
     * @return
     */
    MessageBody getEmpByProId(int pid, MessageBody msg);
}
