package com.zll.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("hello-test2")
public class Test2 {

    @Test
    @DisplayName("test-001")
    void test001(){
        System.out.println("test 001");
    }
}
