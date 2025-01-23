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
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        Sheet sheet = workbook.createSheet("卸数信息");
        int num = 0;
        int startLine0 = 3;
        try (Stream<Path> paths = Files.walk(dir)) {
            List<Path> files = new ArrayList<>(paths
                    .filter(Files::isRegularFile)
                    .toList());
            FileOutputStream outputStream = new FileOutputStream(excelFileName);
        //清除目录下不是以.sql结尾的文件
            files.removeIf(file_rm -> !file_rm.toString().endsWith(".sql"));
            for (Path file : files) {
                //写入到的excel里面写入数据
                Row row = sheet.createRow(num);
                Cell cell0 = row.createCell(0);//表名称
                Cell cell1 = row.createCell(1);//目标系统
                Cell cell2 = row.createCell(2);//定长数据
                Cell cell3 = row.createCell(3);//sql
                Cell cell4 = row.createCell(4);//目标系统表名
                Cell cell5 = row.createCell(5);//where条件
                Cell cell6 = row.createCell(6);//备注
                Cell cell7 = row.createCell(7);//备注
                Cell cell8 = row.createCell(8);//备注
                Cell cell9 = row.createCell(9);//备注
                Cell cell10 = row.createCell(10);//备注
                Cell cell11 = row.createCell(11);//备注
                Cell cell12 = row.createCell(12);//备注
                Cell cell13 = row.createCell(13);//备注
                Cell cell14 = row.createCell(14);//备注
                Cell cell15 = row.createCell(15);//备注
                Cell cell16 = row.createCell(16);//备注
                Cell cell17 = row.createCell(17);//备注
                Cell cell18 = row.createCell(18);//备注
                Cell cell19 = row.createCell(19);//备注
                Cell cell20 = row.createCell(20);//备注
                Cell cell21 = row.createCell(21);//备注
                Cell cell22 = row.createCell(22);//备注
                Cell cell23 = row.createCell(23);//备注

                List<String> lines = Files.readAllLines(file);
                cell0.setCellValue("CS4");
                cell1.setCellValue("");
                cell2.setCellValue("CS4DB");
                cell3.setCellValue("V7CORE");
                //cell4写入文件名的32位哈希值
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(file.getFileName().toString().getBytes());
                byte[] digest = md5.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b));
                }
                cell4.setCellValue(sb.toString());
                //cell5写入文件名截取12-22位字符，并大写
                cell5.setCellValue(file.getFileName().toString().substring(11, 22).toUpperCase());
                cell6.setCellValue("");
                cell7.setCellValue("");
                cell8.setCellValue("");
                cell9.setCellValue("");
                cell10.setCellValue("");
                cell11.setCellValue("");
                cell12.setCellValue("");
                cell13.setCellValue("");
                //读取文件第三行开始到包含FROM行的内容，包括from行的内容

                StringBuilder sCell0 = new StringBuilder();//sql拼接
                for (int i = startLine0-1; i <= lines.size() ; i++) {
                    sCell0.append(lines.get(i)).append("\n");
                    if (lines.get(i).contains("FROM")) {
                        break;
                    }
                }
                cell14.setCellValue(sCell0.toString());
                //cell15写入文件第一行内容
                cell15.setCellValue(lines.get(0));
                //cell16写入文件名去掉后缀，cell17写入文件名去掉.sql后缀
                cell16.setCellValue(file.getFileName().toString().substring(0, file.getFileName().toString().length() - 4));
                cell17.setCellValue(file.getFileName().toString().substring(0, file.getFileName().toString().length() - 4));
                //cell18写入文件第二行内容
                cell18.setCellValue(lines.get(1));
                //cell19写入，如果文件最后一行包含WHERE，则写入最后一行内容，否则写入空
                if (lines.get(lines.size()-1).contains("WHERE")) {
                    cell19.setCellValue(lines.get(lines.size()-1));
                } else {
                    cell19.setCellValue("");
                }
                cell20.setCellValue("");
                cell21.setCellValue("");
                cell22.setCellValue("");
                //cell23写入第四行开始到FROM行之前的内容，用，分隔
                StringBuilder sCell1 = new StringBuilder();

                for (int i = startLine0; i <= lines.size() ; i++) {

                    if (lines.get(i).contains("FROM")) {
                        break;
                    }
                    //如果这一行是以''和空格开头，则去掉开头的‘’空格，
                    if (lines.get(i).startsWith("'' ")) {
                        sCell1.append(lines.get(i).substring(3));
                    } else {
                        sCell1.append(lines.get(i));
                    }
                    sCell1.append(",").append(lines.get(i));
                }
                sCell1.append(",");
                cell23.setCellValue(sCell1.toString());
                num++;
            }
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

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

    @Test
    void test10() {
        Redhat002  redhat002 = new Redhat002();
        System.out.println(redhat002.getName());
        boolean b = redhat002.getName().startsWith("1");
        System.out.println(b);
    }

    @Test
    void test11() {
        Redhat002 redhat002 = new Redhat002();
        redhat002.setAge("1");
        List<Redhat002> list = new ArrayList<>();
        list.add(redhat002);
        //for循环
        for (int i = 0; i < 3; i++) {
            Redhat002 redhat002_1 =  list.get(0);
            redhat002_1.setAge("20");
        }
        System.out.println(list.get(0).getAge());
    }

    @Test
    void test12() {
        StringBuilder content = new StringBuilder();
        String s = "KZ000000001|KZ000000002|KZ000000003|KZ000000004|KZ000000005||||||||";
        String[] parts = s.split("\\|");
        for (String part : parts) {
            if (!part.isEmpty()) {
                if (content.length() > 0) {
                    content.append("|");
                }
                content.append(part);
            }
        }
        System.out.println(content);

        String s1 = "";
        String[] split = s1.split("\\|");
        System.out.println(split.length);
    }

    @Test
    void test13() throws NoSuchAlgorithmException {
        String s = "CS4_V7CORE_KDPB_DQDQZC";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(s.getBytes());
        md5.update(s.getBytes());
        byte[] digest = md5.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());
    }

    @Test
    void test14() {
        String s = "\"\" ABCD";
        System.out.println(s.startsWith("\" "));
    }


    @Test
    void test15() {
        String originalString = "This is a test string with special characters like $";
        String stringToReplace = "$";
        String replacement = "USD()";
        System.out.println(Matcher.quoteReplacement(replacement));
        System.out.println(originalString.replaceAll(stringToReplace, replacement));
        String result = originalString.replaceAll(Pattern.quote(stringToReplace), Matcher.quoteReplacement(replacement));
        System.out.println(result);
    }

    @Test
    void test16() {
        //读取本地文件夹中所有sql格式文件，输出文件中最后一行有where条件的所有文件名
        Path dir = Paths.get("/Users/hezhangqi/echo_station/workspace/");
        try (Stream<Path> paths = Files.walk(dir)) {
            List<Path> files = new ArrayList<>(paths
                    .filter(Files::isRegularFile)
                    .toList());
            //清除目录下不是以.sql结尾的文件
            files.removeIf(file_rm -> !file_rm.toString().endsWith(".sql"));
            for (Path file : files) {
                List<String> lines = Files.readAllLines(file);
                if (lines.get(lines.size()-1).contains("WHERE")) {
                    //第一列输出文件名截取12-22位字符，并大写,第二列输出文件第一行内容，输出到1.csv文件中
                    System.out.println(file.getFileName().toString().substring(11, 22).toUpperCase() + "," + lines.get(0));
                    //读取另一个文件，如果文件名在这个的其中一行中，那么在这个记录后面加上‘是’,并写入到1.csv文件中
                    Path path = Paths.get("/Users/hezhangqi/echo_station/workspace/1.csv");
                    List<String> strings = Files.readAllLines(path);
                    for (String string : strings) {
                        if (string.equals(file.getFileName().getFileName().toString())) {
                            Files.writeString(path, string + ",是", StandardCharsets.UTF_8);
                        }
                    }


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test17() {
        //读取本地目录ods.txt文件的内容，如果某个行在list集合中，则在这一样写入 增量，否则写入全量
        Path path = Paths.get("/Users/hezhangqi/echo_station/workspace/ods.txt");
        List<String> list = new ArrayList<>();
        list.add("KZ000000001");
        list.add("KZ000000002");
        list.add("KZ000000003");
        list.add("KZ000000004");
        list.add("KZ000000005");
        try {
            List<String> strings = Files.readAllLines(path);
            for (String string : strings) {
                if (list.contains(string)) {
                    System.out.println(string + ",增量");
                } else {
                    System.out.println(string + ",全量");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test18() {
        BigDecimal bigDecimal = new BigDecimal("1.23456789");
        BigDecimal bigDecimal1 = new BigDecimal("1.23456789");
        System.out.println(bigDecimal1 == bigDecimal);
    }

}
