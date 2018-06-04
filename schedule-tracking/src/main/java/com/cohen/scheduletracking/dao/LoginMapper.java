package com.cohen.scheduletracking.dao;

import com.cohen.redis.annotation.RedisCached;
import com.cohen.scheduletracking.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface LoginMapper {

    @RedisCached
    Employee checkUserName(@Param("userName") String userName);

    @RedisCached
    Employee checkPassword(@Param("userName") String userName, @Param("password") String password);

    @RedisCached
    Employee checkValid(@Param("userName") String userName, @Param("password") String password,
            @Param("isValid") String isValid);
}
