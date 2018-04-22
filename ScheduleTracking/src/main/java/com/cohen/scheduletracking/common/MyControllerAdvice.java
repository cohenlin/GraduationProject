package com.cohen.scheduletracking.common;

import com.cohen.scheduletracking.utils.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * 控制器建言，所以关于controller的全局配置可以在此类中定义
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
}
