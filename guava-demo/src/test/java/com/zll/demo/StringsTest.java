package com.zll.demo;

import com.google.common.base.Strings;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public class StringsTest {

    @Test
    public void test001() {
        String s = Strings.nullToEmpty(null);
        System.out.println(s =="");
        String s1 = Strings.nullToEmpty("");
        System.out.println(s1);
        String a = Strings.nullToEmpty("a");
        System.out.println(a);
    }

    @Test
    public void test002(){
        String s = Strings.emptyToNull(null);
        System.out.println(s);
        System.out.println(s == null);

        String s1 = Strings.emptyToNull("");
        System.out.println(s1 == null);

        String a = Strings.emptyToNull("a");
        System.out.println(a == "a");
    }

    @Test
    public void test003(){
        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty(""));
        System.out.println(Strings.isNullOrEmpty("a"));
    }


    @Test
    public void test004(){
        String a = Strings.padStart("a", 2, '-');
        System.out.println(a);

        String a1 = Strings.padStart("a", 10, '0');
        System.out.println(a1);
    }


    @Test
    public void test005(){
        String s = Strings.padEnd("a", 2, 'x');
        System.out.println(s);

        String s1 = Strings.padEnd("a", 1, 'x');
        System.out.println(s1);
    }

    @Test
    public void test006(){
        String repeat = Strings.repeat("2", 10);
        System.out.println(repeat);
    }

    /**
    查找两个字符串共同的前缀或者后缀
     *
     */
    @Test
    public void test007(){
        String s = Strings.commonPrefix("aa", "aax");
        System.out.println(s);

        String s1 = Strings.commonSuffix("aabc", "abc");
        System.out.println(s1);
    }


    @Test
    public void test008(){
        String s = Strings.lenientFormat("%s a", 1);
        System.out.println(s);
        String s1 = Strings.lenientFormat("%s + %s = ");
        System.out.println(s1);
        String s2 = Strings.lenientFormat("%s + %s = ",1,2);
        System.out.println(s2);
    }
}
