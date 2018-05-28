package com.cohen.scheduletracking.common.shiro;

import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.service.LoginService;
import com.cohen.scheduletracking.utils.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 林金成
 * @date 2018/5/1319:55
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo authenticationInfo = null;
        String username = String.valueOf(token.getPrincipal());
        String password = String.valueOf((char[]) token.getCredentials());
        Employee user = loginService.login(username, MD5Util.MD5(password));
        if (user != null) {
            authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        }
        return authenticationInfo;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Employee user = (Employee)this.getAvailablePrincipal(principalCollection);// 获取登录用户
        Set<String> set = new HashSet<>();
        set.add(String.valueOf(user.getLevel()));// "1", "2", "3"
        info.setRoles(set);
        return info;
    }
}
