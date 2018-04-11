package com.cohen.scheduletracking.common.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.cohen.scheduletracking.entity.Employee;

@Component
public interface LoginMapper {

    Employee checkUserName(@Param("userName") String userName);

    Employee checkPassword(@Param("userName") String userName, @Param("password") String password);

    Employee checkValid(@Param("userName") String userName, @Param("password") String password,
            @Param("isValid") boolean isValid);
}
