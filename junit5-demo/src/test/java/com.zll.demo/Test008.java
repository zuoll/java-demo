package com.zll.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Test008 {

    @Test
    void test001(){
        System.out.println("test001");
    }

    @Nested
    @DisplayName("nest test class")
    class NestTest{

        @Test
        void test001(){
            System.out.println("nest class test 001");
        }
    }
}
