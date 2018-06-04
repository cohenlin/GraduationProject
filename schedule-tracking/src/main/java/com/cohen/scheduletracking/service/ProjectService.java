package com.cohen.scheduletracking.service;

import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.entity.Project;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 项目管理的业务类
 *
 * @author 林金成
 * 2018年4月5日
 */
public interface ProjectService {

    /**
     * 保存项目信息
     *
     * @return 影响行数
     */
    Integer save(Project project, HttpSession session);

    /**
     * 保存文件与项目、任务的关联关系
     */
    Integer saveFile(String fileName,String filePath, Integer id, Integer flg);

    MessageBody listFiles(MessageBody msg, Integer pid);

    MessageBody deleteFiles(MessageBody msg, String fileName, String filePath, Integer pid);

    MessageBody list(MessageBody msg, HttpSession session);

    /**
     * 查询项目参与员工
     *
     * @param pid
     * @param msg
     * @return
     */
    MessageBody getEmpByProId(int pid, MessageBody msg);

    /**
     * 获取项目信息回显
     *
     * @param id
     * @param msg
     * @return
     */
    MessageBody getProjectById(int id, MessageBody msg);

    /**
     * 校验权限，若权限足够，则编辑回显，若权限不足够，则禁止
     *
     * @param pid
     * @param session
     * @param msg
     * @return
     */
    MessageBody checkLevel(int pid, HttpSession session, MessageBody msg);

    /**
     * 设置为已完成
     *
     * @return
     */
    MessageBody finish(int id, MessageBody msg, HttpSession session);

    /**
     * 回滚项目状态至未完成
     */
    MessageBody rollBack(int id, MessageBody msg, HttpSession session);

    /**
     * 设置为审核
     */
    MessageBody examine(int id, MessageBody msg, HttpSession session);

    /**
     * 删除
     *
     * @return
     */
    MessageBody delete(int id, MessageBody msg, HttpSession session);

    /**
     * 查询需要被当前用户审核的项目
     */
    MessageBody listExamine(MessageBody msg, HttpSession session);
    int delete(String fileName);
}
