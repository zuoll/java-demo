package com.zll.demo;

import cn.hutool.core.util.EscapeUtil;
import org.junit.Test;

/**
 * 转义工具测试
 */
public class EscapeUtilTest {
    @Test
    public void test001(){
        String s = EscapeUtil.escapeHtml4("<a>你好啊</a>");
        System.out.println(s);

        String s1 = EscapeUtil.unescapeHtml4(s);
        System.out.println(s1);
    }


}
