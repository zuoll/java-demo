package com.zll.demo;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.sun.deploy.util.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Struct;
import java.util.Arrays;

public class StrUtilTest {

    @Test
    public void test001() {
        String b = "    ";
        Assert.assertTrue(StrUtil.isBlank(b));

        String c = "   aa  ";
        System.out.println(StrUtil.trim(c));

        String d = "  a b 你 好 ";
        System.out.println(StrUtil.cleanBlank(d));

        String e = "aaaaabbbcccdddeeeeffff";
        String[] cut = StrUtil.cut(e, 4);
        Arrays.stream(cut).forEach(a -> System.out.println(a));
    }

    @Test
    public void test002() {
        String str = "1,2,3,4,  5";

        int[] ints = StrUtil.splitToInt(str, ",");
        Arrays.stream(ints).forEach(i -> System.out.println(i));
    }

    @Test
    public void test003() {
        String template = "你好{name} {phone}";
        String ret = StrUtil.format(template, Dict.create().set("name", "zs").set("phone", "13798452743"));
        System.out.println(ret);
        String format = StrUtil.format(template, Dict.create().set("name", "zs").set("phone", null));
        System.out.println(format);
    }


    /**
     * 分离strip
     */
    @Test
    public void test004() {
        String str = "abcd123def";
        String strip = StrUtil.strip(str, "ab", "ef");
        System.out.println(strip);

        String s = StrUtil.stripIgnoreCase(str, "Ab", "EE");
        System.out.println(s);
    }

    @Test
    public void test005() {
        String s = "aabbccddcbcff";
        int idx  = StrUtil.lastIndexOf(s, "c", s.length(), false);
        System.out.println(idx);
        char c = s.toCharArray()[idx];
        System.out.println(c);
        char c2 = s.toCharArray()[idx-1];
        System.out.println(c2);
    }

    @Test
    public void test006() {
        String s = "aabbccddcbcff";
        String replace = StrUtil.replace(s, "c", "X");
        System.out.println(replace);

        String s1 = StrUtil.padPre(s, 20, "0");
        System.out.println(s1);
        String s2 = StrUtil.padAfter(s, 20, "1");
        System.out.println(s2);
    }

    @Test
    public void test007() {

        String s = StrUtil.upperFirst("key");
        System.out.println(s);
        String s1 = StrUtil.lowerFirst("KEY");
        System.out.println(s1);

    }

    @Test
    public void test008() {
        String ret = StrUtil.sub("abcd213erff", 2, 5);//[2,5)
        System.out.println(ret);

        String ret1 = StrUtil.sub("abcdefg", -1, 2);
        System.out.println(ret1);
    }

    @Test
    public void test010() {
        String s = StrUtil.repeatAndJoin("?", 5, ",");
        System.out.println(s);
    }


    @Test
    public void test011() {
        String s = StrUtil.removePrefix("aaabbbccc","aaa");
        System.out.println(s);
    }


    @Test
    public void test012(){
        String text = "我是一段正文，很长的正文，需要截取的正文";
        String str = StrUtil.maxLength(text, 5);
        System.out.println(str);
    }

    @Test
    public void test013(){
        String hello_world = StrUtil.toCamelCase("hello_world");
        System.out.println(hello_world);

        String helloWorldYouAndMe = StrUtil.toUnderlineCase("helloWorldYouAndME");
        System.out.println(helloWorldYouAndMe);
    }

    @Test
    public void test014(){
        String s = StrUtil.cleanBlank("   123   cxx ");
        System.out.println("|"+s+"|");

        boolean b = StrUtil.containsAny("abcd", "a", "1");
        System.out.println(b);

        boolean b2 = StrUtil.containsAny("abc", "1", "2");
        System.out.println(b2);

    }


    @Test
    public void test015(){
        String s = StrUtil.center("aaa", 10);
        System.out.println("|"+s+"|");
    }

}
