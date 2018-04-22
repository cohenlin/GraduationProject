package com.cohen.scheduletracking.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

/**
 * 等同于在web.xml配置springmvc的启动
 * @author 林金成
 * @date 2018/4/2213:24
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringContextConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
        filter = new CharacterEncodingFilter();
        ((CharacterEncodingFilter) filter).setEncoding("UTF-8");
        ((CharacterEncodingFilter) filter).setForceEncoding(true);
        return super.registerServletFilter(servletContext, filter);
    }

    //    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        // 创建基于注解的springmvc上下文
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//
//        ctx.register(SpringMvcConfig.class);// 注册springmvc的配置类
//        ctx.setServletContext(servletContext);// 与当前web应用的域对象servletContext进行关联
//
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//        dispatcher.addMapping("/");
//        dispatcher.setLoadOnStartup(1);
////        dispatcher.setInitParameter("contextConfigLocation", "classpath:spring-mvc.xml");
//    }
}
