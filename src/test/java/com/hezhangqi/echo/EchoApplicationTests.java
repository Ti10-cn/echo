package com.hezhangqi.echo;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2022-12-27 20:17:23
 * @Description: 
 */

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hezhangqi.echo.controller.CallBackTestController;
import com.hezhangqi.echo.enums.datatype.StatusEnum;
import com.hezhangqi.echo.pojo.model.Recv001;

@SpringBootTest
class EchoApplicationTests {
    @Autowired
    private CallBackTestController callBackTestController;

    
    @Test
    void contextLoads() {
        // int i = 1;
        // boolean in = StatusEnum.isIn("9999");
        // System.out.println(in);
        // StatusEnum statusEnum = StatusEnum.get("0000");
        // System.out.println(statusEnum.getId());
        // //获得枚举类的所有枚举值
        // StatusEnum[] values = StatusEnum.values();
        // for (StatusEnum value : values) {
        //     System.out.println(value);
        // }
        Recv001 recv001 = new Recv001("", StatusEnum.SUCCESS);
        boolean equals = StringUtils.equals(recv001.getId(), "");
        System.out.println(equals);
    }

}
