package com.zll.demo;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import org.junit.Test;


/**
 * 16进制
 */
public class HexUtilTest {

    @Test
    public void test001(){
        String s = "我是中国人";
        String s1 = HexUtil.encodeHexStr(s, CharsetUtil.CHARSET_UTF_8);
        System.out.println(s1);

        String s2 = HexUtil.decodeHexStr(s1);
        System.out.println(s2);


    }


    @Test
    public void test002(){


        String s = HexUtil.toUnicodeHex('\u2001');
        System.out.println(s);

        String s2 = HexUtil.toUnicodeHex('中');
        System.out.println(s2);

    }


    @Test
    public void test003(){
        String s = "0x213231";
        boolean hexNumber = HexUtil.isHexNumber(s);
        System.out.println(hexNumber);
    }

}
