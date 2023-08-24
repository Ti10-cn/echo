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

    @Override
    public <T extends CommEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnumConverter<>(targetType);
    }

    private record StringToEnumConverter<T extends CommEnum>(Class<T> enumType) implements Converter<String, T> {

        @Override
            public T convert(String source) {
                for (T enumValue : enumType.getEnumConstants()) {
                    if (enumValue.getValue().equals(source)) {
                        return enumValue;
                    }
                }
                throw new IllegalArgumentException("Invalid code for " + enumType.getSimpleName() + ": " + source);
            }
        }
}
