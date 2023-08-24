package com.hezhangqi.echo.config;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-09 09:36:21
 * @Description: 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hezhangqi.echo.interceptor.EchoRequestInterceptor;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    private EchoRequestInterceptor echoRequestFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(echoRequestFilter).addPathPatterns("/**");
    }

}
