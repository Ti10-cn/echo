package com.hezhangqi.echo.pojo.vo;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-08 16:15:49
 * @Description: 
 */

import java.io.Serial;
import java.io.Serializable;

import com.hezhangqi.echo.enums.datatype.StatusEnum;

public final class BaseResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 3886133510113334083L;

    private StatusEnum code;
    private String message;

    private T data;

    //无参构造方法中将响应码置为DefaultStatus中的SUCCESS
    public BaseResponse() {
        this.code = StatusEnum.SUCCESS;
        this.message = StatusEnum.SUCCESS.getLongName();
    }

    public BaseResponse(T data) {
        this();
        this.data = data;
    }

    public StatusEnum getCode() {
        return code;
    }

    public BaseResponse<T> setCode(StatusEnum code) {
        this.code = code;
        this.message = code.getLongName();
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> BaseResponse<T> with(StatusEnum code) {
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = code.getLongName();
        return response;
    }

    public static <T> BaseResponse<T> with(StatusEnum code, String message) {
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = message;
        return response;
    }

    public static <T> BaseResponse<T> with(StatusEnum code, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = code.getLongName();
        response.data = data;
        return response;
    }

    public static <T> BaseResponse<T> with(StatusEnum code, String message, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = message;
        response.data = data;
        return response;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code.getValue() +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
