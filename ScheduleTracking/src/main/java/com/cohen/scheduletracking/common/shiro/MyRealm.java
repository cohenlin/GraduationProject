package com.cohen.scheduletracking.common.shiro;

import com.cohen.scheduletracking.entity.Employee;
import com.cohen.scheduletracking.service.LoginService;
import com.cohen.scheduletracking.utils.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

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
     * 权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Iterator i = principalCollection.iterator();
        while (i.hasNext()) {
            Object next = i.next();
            System.out.println(next);
        }
        return null;
    }
}
