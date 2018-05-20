package com.cohen.scheduletracking.dao;

import com.cohen.scheduletracking.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ProjectMapper {
    /**
     * 保存项目信息
     *
     * @param project : 项目信息业务实体类
     * @return
     */
    int insert(Project project);

    List<Project> list(@Param("id") int id);

    List<Project> listByProjectId(@Param("proIds") List<Integer> proIds);

    /**
     * 根据id查项目信息
     *
     * @param id
     * @return
     */
    Project getProjectById(@Param("id") int id);

    int finish(Map<String, Object> params);

    List<Project> listByParams(@Param("project") Project project);
}
