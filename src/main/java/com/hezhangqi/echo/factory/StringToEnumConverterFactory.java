//package com.hezhangqi.echo.factory;
///*
// * @Author: ti_cn ti_cn@icloud.com
// * @Date: 2023-05-06 16:13:43
// * @Description:
// */
//
//import com.hezhangqi.echo.enums.CommEnum;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.convert.converter.ConverterFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class StringToEnumConverterFactory implements ConverterFactory<String, CommEnum> {
//
//    @Override
//    public <T extends CommEnum> Converter<String, T> getConverter(Class<T> targetType) {
////        System.out.println("转换器进来了");
////        System.out.println(targetType.toString());
////        return source ->  {
////            for (T t : targetType.getEnumConstants()) {
////                if (t.getValue().equals(source)) {
////                    System.out.println("abc");
////                    return t;
////                }
////            }
////            return null;
////        };
//    }
//}
