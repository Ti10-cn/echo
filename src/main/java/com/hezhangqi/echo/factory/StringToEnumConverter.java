package com.hezhangqi.echo.factory;

import java.util.Map;

import org.springframework.core.convert.converter.Converter;

import com.google.common.collect.Maps;
import com.hezhangqi.echo.enums.CommEnum;

import cn.hutool.core.util.ObjectUtil;

//实现Converter接口，将String转换为枚举类型
public class StringToEnumConverter<T extends CommEnum> implements Converter<String, T> {

    private Map<String, T> enumMap = Maps.newHashMap();

    public StringToEnumConverter(Class<T> enumType) {
        T[] enums = enumType.getEnumConstants();
        for (T e : enums) {
            enumMap.put(e.getValue(), e);
        }
    }

    @Override
    public T convert(String source) {
        T t = enumMap.get(source);
        if (ObjectUtil.isNull(t)) {
            throw new IllegalArgumentException("无法匹配对应的枚举类型");
        }
        return t;
    }
}
