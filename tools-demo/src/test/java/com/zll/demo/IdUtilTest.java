package com.zll.demo;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

/**
 * 分布式下的唯一id
 * UUID
 * ObjectId（MongoDB）
 * Snowflake（Twitter）
 */
public class IdUtilTest {

    @Test
    public void test001(){
        String s = IdUtil.randomUUID();
        System.out.println(s);
        System.out.println(s.length());

        String s1 = IdUtil.simpleUUID();
        System.out.println(s1);
        System.out.println(s1.length());

        /**
         * a246e2fc-e93f-49c8-8cb0-7dd4e07cc447
         * 4ba7d9ceda254dd8a64377bf5a1d7c31
         */
    }


    //mongo 的分布式唯一id算法
    @Test
    public void test002(){
        String s = IdUtil.objectId();
        System.out.println(s);
    }


    @Test
    //twitter 的snowflake 雪花算法
    public void test003(){
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        System.out.println(snowflake.nextId());
        System.out.println(snowflake.nextId());
    }
}
