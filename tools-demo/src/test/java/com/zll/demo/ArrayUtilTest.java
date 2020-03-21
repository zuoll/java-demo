package com.zll.demo;

import cn.hutool.core.util.ArrayUtil;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.List;

public class ArrayUtilTest {

    @Test
    public void test001() {
        int[] a = {};
        int[] b = null;
        System.out.println(ArrayUtil.isEmpty(a));
        System.out.println(ArrayUtil.isEmpty(b));

        int[] c= {1,2,3};
        System.out.println(ArrayUtil.isNotEmpty(c));
    }

    @Test
    public void test002(){
        String[] ss = ArrayUtil.newArray(String.class, 3);
        System.out.println(ss.length);

        String[] resize = ArrayUtil.resize(ss, 10);

        System.out.println(resize.length);
        for (int i=0; i<10;i++){

            resize[i] ="a"+i;
        }

        String[] bs = {"x","y","z"};

        String[] strings = ArrayUtil.addAll(resize, bs);

        Arrays.stream(strings).forEach(s-> System.out.println(s));
    }

    @Test
    public void test003(){
        Integer[] c = {1,2,4,4,5,6};
        Integer[] d = ArrayUtil.clone(c);
        Integer[] e = ArrayUtil.addAll(c, d);
        Arrays.stream(e).forEach(i-> System.out.println(i));
    }

    @Test
    public void test004(){
        int[] a = {1,2,32,3};
        int[] clone = ArrayUtil.clone(a);
        Arrays.stream(clone).forEach(i-> System.out.println(i));
    }


    @Test
    public void test005(){
        Integer[] c = {1,2,24,5};
        System.out.println(c.length);
        boolean array = ArrayUtil.isArray(c);
        System.out.println(array);

        System.out.println(ArrayUtil.contains(c, 1));
        System.out.println(ArrayUtil.contains(c, 1000));

        List<Integer> integers = Arrays.asList(1, 2, 23);
        System.out.println(ArrayUtil.isArray(integers));
    }

    @Test
    public void test006(){

        int[] a = {1,2,3,4};
        Integer[] wrap = ArrayUtil.wrap(a);
        int[] ints = ArrayUtil.unWrap(wrap);
        System.out.println(Arrays.toString(ints));
    }
}
