package com.hezhangqi.echo.pojo.model;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-06 18:05:11
 * @Description: 
 */


import com.hezhangqi.echo.enums.datatype.StatusEnum;

import javax.validation.constraints.NotNull;
import java.io.Serial;

public class Recv001 implements java.io.Serializable{

    @Serial
    private static final long serialVersionUID = 7682101152060403890L;
    @NotNull
    private StatusEnum statusEnum;
    
    public Recv001(String id, StatusEnum statusEnum) {
        System.out.println("我被调用了");
        this.statusEnum = statusEnum;
    }
    public StatusEnum getStatusEnum() {
        return statusEnum;
    }
    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
    
    
}
