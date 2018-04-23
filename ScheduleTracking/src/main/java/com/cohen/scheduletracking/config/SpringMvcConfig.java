package com.cohen.scheduletracking.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.cohen.scheduletracking.common.NoLoginInterceptor;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC的配置类
 *
 * @author 林金成
 * @date 2018/4/2212:57
 */
@Configuration // 此类为配置类
// @ComponentScan(value = "com.cohen.scheduletracking.controller", // 开启包扫描，扫描value指定的包，filters指定的注解类型
//         includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login.jsp");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * 文件上传处理器
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    /**
     * 视图解析器
     */
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/views/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        return internalResourceViewResolver;
//    }

    /**
     * 处理静态资源
     */
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new NoLoginInterceptor());
    }

    /**
     * 整合fastjson
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }
}