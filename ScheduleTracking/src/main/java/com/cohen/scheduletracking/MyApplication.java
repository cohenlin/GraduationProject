package com.cohen.scheduletracking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 林金成
 * @date 2018/4/238:55
 */
@SpringBootApplication
@EnableTransactionManagement // 开启事务管理(注解)
@MapperScan("com.cohen.scheduletracking.dao") // 扫描dao层接口
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
