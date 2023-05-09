package com.hezhangqi.echo.enums.datatype;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-08 17:22:50
 * @Description: 
 */

import org.apache.commons.lang3.EnumUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hezhangqi.echo.enums.CommEnum;

import cn.hutool.core.util.EnumUtil;

public enum ErrorEnum implements CommEnum {

    APP_ERROR("app_error", "9997", "应用异常"),
    CODE_ERROR("code_error", "9995", "代码异常"),
    API_ERROR("api_error", "9996", "接口异常");

    private String id;
    private String value;
    private String longName;

    ErrorEnum (String id, String value, String longName) {
        this.id = id;
        this.value = value;
        this.longName = longName;
    }

    @JsonCreator
    public static StatusEnum getEnumByValue(String value) {
        System.out.println("反序列化进来了" + value);
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getValue().equals(value)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String getLongName() {
        return longName;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static boolean isIn(String value) {
        return EnumUtils.isValidEnum(StatusEnum.class, value);
    }

    public static StatusEnum getEnum(String value) {
        return EnumUtil.fromString(StatusEnum.class, value);
    }

    // 将枚举的value作为参数传入转换为枚举类型
    public static StatusEnum get(String value) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getValue().equals(value)) {
                return statusEnum;
            }
        }
        return null;
    }

}
