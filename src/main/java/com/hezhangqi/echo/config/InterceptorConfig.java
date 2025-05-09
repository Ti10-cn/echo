package com.hezhangqi.echo.config;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-09 09:36:21
 * @Description: 
 */

import com.hezhangqi.echo.interceptor.EchoRequestInterceptor;
import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    private EchoRequestInterceptor echoRequestFilter;

    @Override
    /** 
     * @Description: 
     * @Param: [registry]
     * @return: void
     * @Author: Echo.qi
     * @Date: 2025/4/28
    */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(echoRequestFilter).addPathPatterns("/**");
    }

}
