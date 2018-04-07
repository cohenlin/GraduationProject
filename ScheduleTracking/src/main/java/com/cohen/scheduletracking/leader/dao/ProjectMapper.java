package com.cohen.scheduletracking.leader.dao;

import com.cohen.scheduletracking.entity.Project;

public interface ProjectMapper {
    /**
     * 保存项目信息
     * 
     * @param project
     *            : 项目信息业务实体类
     * @return
     */
    int insert(Project project);
}
