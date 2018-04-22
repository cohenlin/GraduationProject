package com.cohen.scheduletracking.common;

import com.cohen.scheduletracking.entity.Employee;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 林金成
 * @date 2018/4/2214:44
 */
public class NoLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String[] str = request.getRequestURL().toString().split("/");
        String reqUrl =  str[str.length - 1];
        System.err.println(reqUrl);
        if(reqUrl.split("\\.").length > 1){
            return true;
        }
        if(str[str.length - 1].equals("login")) {// 登录请求放过
            System.out.println("登录请求");
            return true;
        }
        HttpSession session = request.getSession();
        Employee user = (Employee) session.getAttribute("user");
        if(user != null && user.getId() > 0) {// 若已登录放过
            System.out.println("非登录请求！已登录！");
            return true;
        }
        System.out.println("未登录");
        response.sendRedirect("login.jsp");
        return false;
    }
}
