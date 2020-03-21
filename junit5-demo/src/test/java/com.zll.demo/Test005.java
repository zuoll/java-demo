package com.zll.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class Test005 {

    /**
     * 直接跳过
     */
    @Disabled
    @Test
    void test001(){
        System.out.println("test 001");
    }


    @Test
    void test002(){
        System.out.println("test 002");
    }
}
