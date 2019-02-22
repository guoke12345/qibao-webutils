package com.qibao.webutils.common;


import com.qibao.core.filter.LogFilter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class InterceptorConfig extends WebMvcConfigurationSupport {

    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new LogFilter()).addPathPatterns("/**");
        // registry.addInterceptor(new InterfaceAuthCheckInterceptor()).addPathPatterns("/api/**");
        // 如果interceptor中不注入redis或其他项目可以直接new，否则请使用上面这种方式
        super.addInterceptors(registry);
    }
}
