package com.cohen.scheduletracking;

import com.cohen.scheduletracking.config.ApplicationProperty;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 林金成
 * @date 2018/4/238:55
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement // 开启事务管理(注解)
@MapperScan("com.cohen.scheduletracking.dao") // 扫描dao层接口
@EnableConfigurationProperties({ApplicationProperty.class})
public class MyApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext run = SpringApplication.run(MyApplication.class, args);
    }
}
