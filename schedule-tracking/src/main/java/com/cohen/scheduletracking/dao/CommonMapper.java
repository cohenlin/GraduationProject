package com.cohen.scheduletracking.dao;

import com.cohen.redis.annotation.RedisCached;
import com.cohen.redis.annotation.RedisCleared;
import com.cohen.scheduletracking.entity.EmpProject;
import com.cohen.scheduletracking.entity.File;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 处理员工与项目、员工与任务之间关联关系的mapper
 * 
 * @author 林金成
 *         2018年4月6日
 */
@Component
public interface CommonMapper {

    /**
     * 保存员工id与对应的项目ID
     * 
     * @param empId
     *            : 员工ID
     * @param proId
     *            : 项目ID
     */
    @RedisCleared
    int insertEmpProject(@Param("empId") int empId, @Param("proId") int proId, @Param("isManager") String isManager);

    @RedisCached
    List<EmpProject> queryByEmpId(@Param("id") int id);

    @RedisCached
    List<EmpProject> queryByProId(@Param("pid") int id);

    /**
     * 保存文件
     * @param map
     * @return
     */
    @RedisCleared
    Integer saveFile(Map<String, Object> map);

    @RedisCached
    List<File> listFiles(Map<String, Object> map);

    @RedisCleared
    Integer deleteFiles(Map<String, Object> map);
}
