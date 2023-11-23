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
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EchoApplicationTests {
    @Autowired
    private CallBackTestController callBackTestController;

    @Autowired
    private CallBackTestService callBackTestService;

    private Map<String,Object> cache = new HashMap<>();
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
    void test3() throws CharacterCodingException {
        String s = "默认值";
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();
        ByteBuffer buffer = encoder.encode(CharBuffer.wrap(new char[] {'默'}));
        String encoding = Arrays.toString(buffer.array());
        System.out.println(encoding);
    }

    @Test
    void test4() {
        Map<String, String> map2 = test5(cache);
        map2.put("123","456");
        System.out.println(map2);
        System.out.println(cache);
    }

    private Map<String,String> test5(Map cache) {
        Map<String,String> map1 = new HashMap<>();
        cache.put("map",map1);
        return map1;

    }
}
