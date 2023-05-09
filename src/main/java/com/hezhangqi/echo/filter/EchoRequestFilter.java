package com.hezhangqi.echo.filter;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-08 16:00:14
 * @Description: 
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class EchoRequestFilter implements HandlerInterceptor{

    //使用ThreadLocal处理全局参数
    static final ThreadLocal<Map<String,String>> threadLocal = new ThreadLocal<>();

    //前置拦截器
    //统一处理请求数据
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //初始化threadLocal
        System.out.println("我执行了0");
        Map<String, String> map = new HashMap<>();
        map.put("requestURI", request.getRequestURI());
        threadLocal.set(map);
        String put = threadLocal.get().put("requestURI", request.getRequestURI());;
        System.out.println("请求地址："+put);
        return true;
    }


    //后置拦截器
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    
}
