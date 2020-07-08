package com.spring.globalexceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        log.info("全局异常：{}", e);
        return "全局异常";
    }
}
