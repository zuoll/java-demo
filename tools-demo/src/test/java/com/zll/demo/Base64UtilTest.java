package com.zll.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;

public class Base64UtilTest {
    public static void main(String[] args) {
        String s = "我是中国人";
        String encode = Base64.encode(s, CharsetUtil.CHARSET_UTF_8);
        System.out.println(encode);

        byte[] decode = Base64.decode(encode);
        String raw = StrUtil.str(decode, CharsetUtil.UTF_8);
        System.out.println(raw);
    }
}
