package com.hezhangqi.echo.factory;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-06 16:13:43
 * @Description: 
 */

import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.google.common.collect.Maps;
import com.hezhangqi.echo.enums.CommEnum;

public class StringToEnumConverterFactory implements ConverterFactory<String, CommEnum> {
    private static final Map<Class, Converter> CONVERTERS = Maps.newHashMap();

    @Override
    public <T extends CommEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter<String, T> converter = CONVERTERS.get(targetType);
        if (converter == null) {
            converter = new StringToEnumConverter<>(targetType);
            CONVERTERS.put(targetType, converter);
        }
        return converter;
    }

}
