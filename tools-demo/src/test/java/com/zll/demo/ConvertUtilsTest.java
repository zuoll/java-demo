package com.zll.demo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.CharsetUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConvertUtilsTest {

    @Test
    public void test001() {
        int a = 1;
        String str = Convert.toStr(a);
        System.out.println(str);
        long[] b = {1, 2, 3, 5, 6};
        String s = Convert.toStr(b);
        System.out.println(s);
        String[] ss = {"1", "2", "3"};
        Integer[] array = Convert.toIntArray(ss);
        Arrays.stream(array).forEach(i -> System.out.println(i));

        Integer[] array1 = Convert.toIntArray(b);
        Arrays.stream(array1).forEach(i -> System.out.println(i));
    }

    @Test
    public void test002() {
        String d = "2020-02-02";
        Date date = Convert.toDate(d);
        System.out.println(date.getTime());
    }


    @Test
    public void test003() {
        Object[] a = {"a", "你", "好", "", 1};

        List<?> list = Convert.convert(List.class, a);

        list.stream().forEach(item -> System.out.println(item));

        List<?> list2 = Convert.toList(a);
        list2.stream().forEach(item2 -> System.out.println(item2));


        List<String> convert = Convert.convert(new TypeReference<List<String>>() {
        }, a);

        convert.stream().forEach(System.out::println);
    }


    @Test
    public void test005() {

        String a = "1234567890";
        String str = Convert.toSBC(a);
        System.out.println(str);

        //全角转半角
        String toDBC = Convert.toDBC(str);
        System.out.println(toDBC);

    }

    @Test
    public void test006() {
        String str = "我是一个小可爱哦";
        String ss = Convert.toHex(str, CharsetUtil.CHARSET_UTF_8);
        System.out.println(ss);

        String s1 = Convert.hexToStr(ss, CharsetUtil.CHARSET_UTF_8);
        System.out.println(s1);


        //unicode

        String s2 = Convert.strToUnicode(str);
        System.out.println(s2);
        String s3 = Convert.unicodeToStr(s2);
        System.out.println(s3);
        //编码转换
        String result = Convert.convertCharset(str, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        System.out.println(result);//乱码

        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, CharsetUtil.UTF_8);
        System.out.println(raw);
    }


    /**
     * 时间转换
     */
    @Test
    public void test008() {
        long a = 3600 * 2;

        long t = Convert.convertTime(a, TimeUnit.SECONDS, TimeUnit.HOURS);
        System.out.println(t);
    }


    /**
     * 金额转换
     */
    @Test
    public void test009() {
        double m = 12345.67;

        String s = Convert.digitToChinese(m);
        System.out.println(s);
    }


    /**
     * 原始类和包装类的转换
     */

    @Test
    public void test010(){
        //包装类去包装
        Class<?> wrapperClazz = Integer.class;
        Class<?> unWrap = Convert.unWrap(wrapperClazz);

        System.out.println(unWrap.toString());//int


        //原始类包装
        Class<?> rawClazz = int.class;

        Class<?> wrap = Convert.wrap(rawClazz);
        System.out.println(wrap.toString());//class java.lang.Integer

    }


}
