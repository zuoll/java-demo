package com.zll.demo;

import cn.hutool.core.util.RuntimeUtil;
import org.junit.Test;

public class RuntimeUtilTest {

    @Test
    public void test001(){
        String ipconfig = RuntimeUtil.execForStr("ipconfig");
        System.out.println(ipconfig);
    }
}
