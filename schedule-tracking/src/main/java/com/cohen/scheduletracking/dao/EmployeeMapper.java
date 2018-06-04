package com.cohen.scheduletracking.dao;

import com.cohen.redis.annotation.RedisCached;
import com.cohen.redis.annotation.RedisCleared;
import com.cohen.scheduletracking.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 员工信息的mapper
 *
 * @author 林金成
 * 2018年4月6日
 */
@Component
public interface EmployeeMapper {

    /**
     * 根据部门查员工
     */
    @RedisCached
    List<Employee> getEmployeeByDeptId(@Param("deptId") int deptId);

    /**
     * 根据id查员工
     */
    @RedisCached
    Employee getEmployeeById(int id);

    /**
     * 根据id批量查员工
     *
     * @param ids
     * @return
     */
    @RedisCached
    List<Employee> queryById(@Param("ids") List<Integer> ids);

    /**
     * 根据条件修改，动态拼接sql语句
     */
    @RedisCleared
    int changePassword(Map<String, String> map);
}
