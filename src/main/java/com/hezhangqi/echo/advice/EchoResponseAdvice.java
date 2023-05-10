package com.hezhangqi.echo.advice;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-08 17:42:00
 * @Description: 
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hezhangqi.echo.enums.datatype.StatusEnum;
import com.hezhangqi.echo.exception.EchoException;
import com.hezhangqi.echo.interceptor.EchoRequestInterceptor;
import com.hezhangqi.echo.pojo.vo.BaseResponse;

@RestControllerAdvice
public class EchoResponseAdvice implements ResponseBodyAdvice<Object> {
    
    private Boolean resultBoolean = true;
    // ModelAttribute注解的方法会在每个controller方法执行前执行，处理model数据
    @ModelAttribute(name = "globalData")
    public Map<String, Object> getGlobalData() {
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    // 异常统一处理
    // 为防止二次包装，捕获的异常修改resultBoolean为false
    @ExceptionHandler(BindException.class)
    public BaseResponse<String> exceptionHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = bindingResult.getFieldError().getDefaultMessage();
        resultBoolean = false;
        return BaseResponse.with(StatusEnum.ERROR, message);
    }
    @ExceptionHandler(EchoException.class)
    public BaseResponse<String> exceptionHandler(EchoException e) {
        resultBoolean = false;
        return BaseResponse.with(StatusEnum.ERROR, e.getMessage());
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return  resultBoolean && !(returnType.getParameterType() == BaseResponse.class);
    }

    // 在返回之前执行 统一处理响应数据格式，清空threadLocal
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        BaseResponse<Object> baseResponse = new BaseResponse<Object>(body);
        if (body instanceof String) {
            try {
                return new ObjectMapper().writeValueAsString(baseResponse);
            } catch (JsonProcessingException e) {
                // throw new RuntimeException("无法转发json格式", e);
                return BaseResponse.with(StatusEnum.ERROR, "无法转发json格式");
            } finally {
                EchoRequestInterceptor.threadLocal.remove();
            }
        }
        EchoRequestInterceptor.threadLocal.remove();
        // 封装后的数据返回
        return baseResponse;

    }
}
