package com.qibao.core.filter;

import com.qibao.core.util.UUIDGenerator;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.*;
import java.io.IOException;

/**
 * spring boot 日志拦截器 time key 配置
 */
public class LogFilter implements HandlerInterceptor {
    public static final String KEY_PREFIX          = "【TimeKey=";
    public static final String KEY_SUFFIX          = "】";
    public static void start() {
        MDC.remove("timeKey");
        MDC.put("timeKey",createTimeKey());
    }

    public static String createTimeKey() {
        String timeKey = KEY_PREFIX + UUIDGenerator.getUUIDSlip() + KEY_SUFFIX;
        return timeKey;
    }
    //  拦截器配置
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        start();
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
