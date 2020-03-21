package com.zll.demo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

import java.util.List;

public class RandomUtilTest {


    @Test
    public void test001(){
        int i = RandomUtil.randomInt();
        System.out.println(i);
        char c = RandomUtil.randomChar();
        System.out.println(c);
        String s = RandomUtil.randomString(10);
        System.out.println(s);

        List<Integer> list = CollUtil.newArrayList(1,2,2,2,4,4,5,5);
        Integer integer = RandomUtil.randomEle(list);
        System.out.println(integer);

        System.out.println(RandomUtil.randomBoolean());

    }
}
