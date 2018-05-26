package com.cohen.scheduletracking.config;

import com.cohen.scheduletracking.common.shiro.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author 林金成
 * @date 2018/5/1322:51
 */
@Configuration
public class ShiroConfig {

    @Bean
    public MyRealm myRealm() {
        MyRealm myRealm = new MyRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        myRealm.setCredentialsMatcher(credentialsMatcher);
        return myRealm;
    }

    @Bean
    public DefaultSecurityManager securityManager(MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = shiroFilter.getFilterChainDefinitionMap();
        // 资源文件放行
        filterChainDefinitionMap.put("/assets/**", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/changePassword", "anon");
        filterChainDefinitionMap.put("/findPassword", "anon");
        filterChainDefinitionMap.put("/emp/changePassword", "anon");
        // 登出
        filterChainDefinitionMap.put("/logout", "logout");
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setUnauthorizedUrl("/403");
        // 所有请求必须有权限才能访问
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilter.setSuccessUrl("/index");// 登录成功后的首页
        return shiroFilter;
    }
}
