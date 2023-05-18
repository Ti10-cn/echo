package com.hezhangqi.echo.exception;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-10 10:04:03
 * @Description: 
 */

import com.hezhangqi.echo.enums.datatype.ErrorEnum;

import java.io.Serial;

public class EchoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -482374152794249619L;

    public EchoException(ErrorEnum errorEnum) {
        super("[" + errorEnum.getValue() + "]" + errorEnum.getLongName());
    }
}
