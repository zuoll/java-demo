package com.zll.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * assume //假設
 */
public class Test004 {

    @Test
    void test001() {
        assumeTrue(1 > 0);
    }


    //remainder of test
    @Test
    void test002() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
    }


    @Test
    void test003() {
        assumingThat(1>2,()->{
            Assertions.assertEquals(2,2);
        });
    }
}
