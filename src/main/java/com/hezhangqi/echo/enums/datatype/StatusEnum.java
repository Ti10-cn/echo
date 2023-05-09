package com.hezhangqi.echo.enums.datatype;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-06 09:24:38
 * @Description: 
 */

import org.apache.commons.lang3.EnumUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hezhangqi.echo.enums.CommEnum;

import cn.hutool.core.util.EnumUtil;

public enum StatusEnum implements CommEnum {

    SUCCESS("succ", "0000", "交易成功"),
    FAIL("fail", "9999", "交易失败"),
    ERROR("error", "9998", "交易异常");

    private String id;
    private String value;
    private String longName;

    StatusEnum(String id, String value, String longName) {
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
