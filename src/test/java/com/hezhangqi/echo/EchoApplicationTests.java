package com.hezhangqi.echo;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2022-12-27 20:17:23
 * @Description: 
 */

import com.hezhangqi.echo.controller.CallBackTestController;
import com.hezhangqi.echo.pojo.dto.Redhat002;
import com.hezhangqi.echo.service.CallBackTestService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest
class EchoApplicationTests {
    @Autowired
    private CallBackTestController callBackTestController;

    @Autowired
    private CallBackTestService callBackTestService;

    private final Map<String,Object> cache = new HashMap<>();
    @Test
    void contextLoads() {

    }

    //新写一个测试方法
    @Test
    void test() {
        Redhat002 redhat002 = new Redhat002();
        redhat002.setAge("1");
        boolean contains = redhat002.getName().contains("1");
        System.out.println(contains);


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
        Charset charset = StandardCharsets.UTF_8;
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

    private Map<String,String> test5(Map<String,Object> cache) {
        Map<String,String> map1 = new HashMap<>();
        cache.put("map",map1);
        return map1;

    }

    @Test
    void test5() {
        int a = 6000;
        int abc = StringUtils.compare("abc", null);
        System.out.println(abc);
    }

    @Test
    void test6() {
    //生成100个32位纯数字，并放入集合中
        String[] strings = new String[100];

        for (int i = 0; i < 100; i++) {
            String s = String.valueOf((int)((Math.random()*9+1)*1000000000));
        }
    }

    @Test
    void test7() {
        Path dir = Paths.get("/Users/hezhangqi/echo_station/workspace/");
        String excelFileName = "/Users/hezhangqi/echo_station/workspace/output.xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet 1");
        int num = 0;
        int startLine0 = 3;

        try (Stream<Path> paths = Files.walk(dir)) {
            List<Path> files = paths
                    .filter(Files::isRegularFile)
                    .toList();
            FileOutputStream outputStream = new FileOutputStream(excelFileName);

            for (Path file : files) {
                Row row = sheet.createRow(num);
                Cell cell0 = row.createCell(0);//表名称
                Cell cell1 = row.createCell(1);//目标系统
                Cell cell2 = row.createCell(2);//定长数据
                Cell cell3 = row.createCell(3);//sql
                Cell cell4 = row.createCell(4);//目标系统表名
                Cell cell5 = row.createCell(5);//where条件
                StringBuilder sCell0 = new StringBuilder();//sql拼接
//                StringBuilder sCell1 = new StringBuilder();//定长数据
//                StringBuilder sCell2 = new StringBuilder();//目标系统
//                StringBuilder sCell3 = new StringBuilder();
//                StringBuilder sCell4 = new StringBuilder();
//                StringBuilder sCell5 = new StringBuilder();
                List<String> lines = Files.readAllLines(file);
                cell0.setCellValue(file.getFileName().toString().substring(11, 22).toUpperCase());
                cell1.setCellValue(lines.get(0));
                cell2.setCellValue(lines.get(1));
                String[] sLine = lines.get(1).split(":");
                for (int i = startLine0; i <= lines.size() ; i++) {
                    if (lines.get(i).contains("FROM")) {
                        break;
                    }
                    sCell0.append(lines.get(i)).append("\t").append("POSITION(").append(sLine[i-3]).append(")").append("\n");
                }
                sCell0.delete(sCell0.length() - 2, sCell0.length());
                cell3.setCellValue(sCell0.toString());
                if (lines.get(0).equals("ODS")) {
                    cell4.setCellValue("cs4_v7core_" + file.getFileName().toString().substring(11, 22));
                } else {
                    cell4.setCellValue("s_cs4_." + file.getFileName().toString().substring(11, 22));
                }
                if (lines.get(lines.size()-1).contains("WHERE")) {
                    cell5.setCellValue(lines.get(lines.size()-1));
                } else {
                    cell5.setCellValue("");
                }
                num++;
            }
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//            Path fileName = file.getFileName();
//            String substring = fileName.toString().substring(11, 22).toUpperCase();
//            lines.add(0,"V7CORE."+substring);
//            for (String line : lines) {
//                System.out.println(line);
//            }
//            Files.write(file,lines);


    }

    @Test
    void test8() {
        String s = "727090126203653515";
        long l = Long.valueOf(s);
        long l1 = l % (300);
        System.out.println(l1);
    }
    //获取本机的mac地址
    @Test
    void test9() {
        // 创建一个数组来存储两个线程中的字符串
        final String s = "234";

        // 创建两个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 在线程1中访问字符串常量池

                System.out.println(s == "234");
            }
        }).start();

//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // 在线程2中访问字符串常量池
//                strings[1] = "Hello";
//                System.out.println("Thread2: " + strings[1]);
//            }
//        });



    }

    
}
