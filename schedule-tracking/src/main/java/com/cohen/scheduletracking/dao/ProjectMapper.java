package com.cohen.scheduletracking.dao;

import com.cohen.redis.annotation.RedisCached;
import com.cohen.redis.annotation.RedisCleared;
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
    @RedisCleared
    int insert(Project project);

    @RedisCached
    List<Project> list(@Param("id") int id);

    @RedisCached
    List<Project> listByProjectId(@Param("proIds") List<Integer> proIds);

    /**
     * 根据id查项目信息
     *
     * @param id
     * @return
     */
    @RedisCached
    Project getProjectById(@Param("id") int id);

    @RedisCleared
    int finish(Map<String, Object> params);

    @RedisCached
    List<Project> listByParams(@Param("project") Project project);

    @RedisCleared
    int deleteByFileName(@Param("fileName") String fileName);
}
