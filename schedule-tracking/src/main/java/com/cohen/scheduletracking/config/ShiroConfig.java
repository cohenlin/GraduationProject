package com.cohen.scheduletracking.config;

import com.cohen.scheduletracking.common.shiro.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
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
//        filterChainDefinitionMap.put("/menu/**", "anon");
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

    /**
     * 管理shiro声明周期
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 解决@RequiresRoles不生效
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    /**
     * 解决@RequiresRoles不生效
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
