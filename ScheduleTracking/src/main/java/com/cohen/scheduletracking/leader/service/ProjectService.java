package com.cohen.scheduletracking.leader.service;

import java.util.Date;
import java.util.List;

import com.cohen.scheduletracking.entity.Project;

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

    /**
     * 修改项目信息
     * 
     * @return 影响行数
     */
    Integer update(Integer id, Project project);

    /**
     * 根据项目ID检索
     */
    Project getProjectById(Integer id);

    /**
     * 根据日期检索
     */
    List<Project> getProjectByDate(Date begin, Date end);

    /**
     * 根据完成情况查询项目
     */
    List<Project> getProjectByIsFinished(Boolean isFinished);

    /**
     * 查询所有项目信息
     */
    List<Project> getAll();
}
