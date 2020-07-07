package com.spring.globalexceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
public class WebInterceptor implements HandlerInterceptor {
    private Long startTime;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        startTime = new Date().getTime();
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) {
        log.info("url: {}, method: {}", request.getRequestURI(), request.getMethod());
        request.getParameterMap().forEach((key, value) -> log.info("{}: {}", key, value));
        log.info("请求耗时： {}ms", new Date().getTime() - startTime);
    }
}
