package com.hezhangqi.echo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-05 15:36:59
 * @Description: 切面回调自定义注解
 */
@Target(ElementType.METHOD) //注解可以写在方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TransCallBack {
    String value() default "";
}
