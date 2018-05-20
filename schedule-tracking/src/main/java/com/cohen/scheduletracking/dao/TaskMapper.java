package com.cohen.scheduletracking.dao;

import com.cohen.scheduletracking.entity.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TaskMapper {
    int insert(@Param("task") Task task);

    List<Task> list(@Param("id") int id);

    int changeTaskToFinish(Map<String, Object> map);

    int delete(@Param("id") int id);

    Task getTaskById(@Param("id") int id);

    /**
     * g根据project id 检索相关所有任务
     * @param pid
     * @return
     */
    List<Task> listByProId(@Param("pid")int pid);

    List<Integer> listTaskIdByProId(@Param("pid")int pid);

    /**
     * 批量修改任务状态
     * @return
     */
    int changeStatuBatch(@Param("ids") List<Integer> ids,@Param("status") String status);
}
