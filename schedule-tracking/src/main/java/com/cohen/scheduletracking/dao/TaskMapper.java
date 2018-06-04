package com.cohen.scheduletracking.dao;

import com.cohen.redis.annotation.RedisCached;
import com.cohen.redis.annotation.RedisCleared;
import com.cohen.scheduletracking.entity.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TaskMapper {
    @RedisCleared
    int insert(@Param("task") Task task);

    @RedisCached
    List<Task> list(@Param("id") int id);

    @RedisCached
    List<Task> listByParams(@Param("task") Task task);

    @RedisCleared
    int changeTaskToFinish(Map<String, Object> map);

    @RedisCleared
    int delete(@Param("id") int id);

    @RedisCached
    Task getTaskById(@Param("id") int id);

    /**
     * g根据project id 检索相关所有任务
     *
     * @param pid
     * @return
     */
    @RedisCached
    List<Task> listByProId(@Param("pid") int pid);

    @RedisCached
    List<Integer> listTaskIdByProId(@Param("pid") int pid);

    /**
     * 批量修改任务状态
     *
     * @return
     */
    @RedisCleared
    int changeStatuBatch(@Param("ids") List<Integer> ids, @Param("status") String status);
}
