package com.hezhangqi.echo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-05 10:58:30
 * @Description: 联机回调
 */
@Aspect
@Component
public class TransCallBack {
    @Pointcut("@annotation(com.hezhangqi.echo.annotation.TransCallBack)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        //方法前执行
        System.out.println("方法前执行");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        //方法后执行
        
        System.out.println("方法后执行");
    }

    @AfterReturning(value = "pointCut()",returning = "rvt")
    public void afterReturning(JoinPoint joinPoint,Object rvt) {
        //方法返回后执行
        System.out.println("方法返回后执行");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e) {
        //方法抛出异常执行
        System.out.println("方法抛出异常执行");
    }
}
