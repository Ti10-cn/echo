package com.hezhangqi.echo;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2022-12-27 20:17:23
 * @Description: 
 */

import com.hezhangqi.echo.controller.CallBackTestController;
import com.hezhangqi.echo.enums.datatype.StatusEnum;
import com.hezhangqi.echo.pojo.dto.Redhat002;
import com.hezhangqi.echo.pojo.model.Recv001;
import com.hezhangqi.echo.service.CallBackTestService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

@SpringBootTest
class EchoApplicationTests {
    @Autowired
    private CallBackTestController callBackTestController;

    @Autowired
    private CallBackTestService callBackTestService;

    
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

    //新写一个测试方法
    @Test
    void test() {
       String s = "123#456#789";
         String[] split = s.split("#",-1);
         StringBuffer s1 = new StringBuffer();
        for (String value : split) {
            s1.append(String.format("\t%s,", value));
        }

            System.out.println(s1);

        String s2 = s1 + "1";



    }

//    @Test
//    void test1() {
//        System.out.println(callBackTestService.findAll());
//    }

    @Test
    void test2() {
//        Redhat002 redhat002 = new Redhat002();
//        System.out.println(redhat002.getId());
//        long l =  redhat002.getId() + 1;
//        System.out.println(l);
//
//        //新建一个数组array,有118个元素
//        String[] sMingxi = new String[118];
//        //循环遍历数组array,给每个元素赋值
//        Arrays.fill(sMingxi, "0");
//        String[] sMingxi1 = new String[30];

        Redhat002  redhat002 = new Redhat002();
        Class<?> clazz = redhat002.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
//            field.setAccessible(true);
            System.out.println(field.getType().toString());
//            try {
//                Object o = field.get(redhat002);
//                System.out.println(o);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
        }


    }

    @Test
    void test3() {
        String s = "转入123";

        byte[] sBytes = s.getBytes(StandardCharsets.UTF_8);
        for (byte sByte : sBytes) {
            System.out.println(sByte);
        }

    }
}
