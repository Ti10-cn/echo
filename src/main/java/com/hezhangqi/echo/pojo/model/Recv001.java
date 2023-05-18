package com.hezhangqi.echo.pojo.model;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-06 18:05:11
 * @Description: 
 */




import javax.validation.constraints.NotNull;

import com.hezhangqi.echo.enums.datatype.StatusEnum;

import java.io.Serial;

public class Recv001 implements java.io.Serializable{

    @Serial
    private static final long serialVersionUID = 7682101152060403890L;
    @NotNull
    private String id;
    @NotNull
    private StatusEnum statusEnum;
    
    public Recv001(String id, StatusEnum statusEnum) {
        this.id = id;
        this.statusEnum = statusEnum;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public StatusEnum getStatusEnum() {
        return statusEnum;
    }
    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
    
    
}
