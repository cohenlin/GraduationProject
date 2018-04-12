package com.cohen.scheduletracking.leader.dao;

import com.cohen.scheduletracking.entity.Department;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 部门信息mapper
 * 
 * @author 林金成
 *         2018年4月6日
 */
@Component
public interface DepartmentMapper {

    /**
     * 查询所有的部门信息
     */
    List<Department> getAllDepartment();
}
