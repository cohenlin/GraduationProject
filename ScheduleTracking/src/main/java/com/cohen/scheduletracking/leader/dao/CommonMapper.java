package com.cohen.scheduletracking.leader.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
    int insertEmpProject(@Param("empId") int empId, @Param("proId") int proId, @Param("isManager") String isManager);
}
