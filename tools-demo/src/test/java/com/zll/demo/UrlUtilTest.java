package com.zll.demo;

import cn.hutool.core.util.URLUtil;
import org.junit.Test;

public class UrlUtilTest {
    @Test
    public void test001() {
        String url = "http://www.baidu.com?q=微 信&name=你好啊";

        String normalize = URLUtil.normalize(url);
        System.out.println(normalize);

        String encode = URLUtil.encode(url);
        System.out.println(encode);

        String decode = URLUtil.decode(encode);

        System.out.println(decode);
    }


    @Test
    public void test002() {

    }


    @Test
    public void test003() {

    }


    @Test
    public void test004() {

    }

    @Test
    public void test005() {

    }

    @Test
    public void test006() {

    }

    @Test
    public void test007() {

    }

    @Test
    public void test008() {

    }

    @Test
    public void test009() {

    }

    @Test
    public void test010() {

    }
}
