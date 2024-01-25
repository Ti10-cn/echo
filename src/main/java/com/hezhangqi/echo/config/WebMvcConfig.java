//package com.hezhangqi.echo.config;
///*
// * @Author: ti_cn ti_cn@icloud.com
// * @Date: 2023-05-06 16:51:09
// * @Description:
// */
//
//import com.hezhangqi.echo.factory.StringToEnumConverterFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.annotation.Resource;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    /**
//     * 枚举类的转换器工厂 addConverterFactory
//     */
//    @Resource
//    StringToEnumConverterFactory stringToEnumConverterFactory;
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverterFactory(stringToEnumConverterFactory);
//    }
//}
