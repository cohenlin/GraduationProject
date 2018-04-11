package com.cohen.scheduletracking.common.dao;

import com.cohen.scheduletracking.entity.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskMapper {
    int insert(@Param("task") Task task);

    List<Task> list(@Param("id") int id);
}
