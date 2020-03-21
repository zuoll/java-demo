package com.zll.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <a>https://blog.csdn.net/ryo1060732496/article/details/80792246</a>
 */
public class Test1 {


    /**
     * 导入的包路径和原来不同
     *
     * 方法不必再声明为 public
     */
    @Test
    void myFirst() {
        System.out.println("first junit5");
        Assertions.assertEquals(2, 1 + 1);
    }
}
