package com.cohen.scheduletracking.common;

import com.cohen.scheduletracking.entity.MessageBody;
import com.cohen.scheduletracking.utils.DateEditor;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 控制器建言，所以关于controller的全局配置可以在此类中定义
 *
 * @author 林金成
 * @date 2018/4/2214:10
 */
@ControllerAdvice
public class MyControllerAdvice {
    /**
     * 传参时将字符串日期转换为date对象
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    @ExceptionHandler(value = {ShiroException.class})
    @ResponseBody
    public MessageBody exceptionHandler(Exception e) {
        MessageBody msg = new MessageBody();
        if(e instanceof AuthorizationException){
            msg.setStatus("403");
            msg.setBody("您没有访问权限， 请联系管理员！");
        }
        if(e instanceof AuthenticationException){
            msg.setStatus("304");
            msg.setBody("您没有认证， 请登录！");
        }
        return msg;
    }
}
