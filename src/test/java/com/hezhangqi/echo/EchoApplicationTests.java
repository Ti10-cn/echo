package com.hezhangqi.echo;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2022-12-27 20:17:23
 * @Description: 
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;

import com.hezhangqi.echo.annotation.CallBack;
import com.hezhangqi.echo.controller.CallBackTestController;
import com.hezhangqi.echo.dao.Redhat001;
import com.hezhangqi.echo.enums.datatype.StatusEnum;

import java.math.BigDecimal;

@SpringBootTest
class EchoApplicationTests {
    @Autowired
    private CallBackTestController callBackTestController;

    
    @Test
    void contextLoads() {
       int i = 1;
        // System.out.println(i);
        // BigDecimal bigDecimal01 = new BigDecimal("0.00000000000000000123");
        // System.out.println(bigDecimal01);
        // System.out.println("helloworld");
        // System.out.println("test");

        // // 生成一组随机数
        // for (int j = 0; j < 10; j++) {
        //     System.out.println(Math.random());
        // }
        boolean in = StatusEnum.isIn("9999");
        System.out.println(in);
        StatusEnum statusEnum = StatusEnum.getEnum("00");
        System.out.println(statusEnum.getId());

    }

}
