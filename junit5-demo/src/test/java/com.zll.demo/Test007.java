package com.zll.demo;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

//TODO

/**
 */
@Tag("group1")
public class Test007 {

    @Test
    @Tag("group1")
    void test001() {
        System.out.println("group 1");
    }


    @Test
    @Tag("group1")
    void test002() {
        System.out.println("test002 group 1");
    }


    @Test
    @Tag("group2")
    void test003() {
        System.out.println("test003 group 2");
    }


    @Test
    @Tag("group2")
    void test004() {
        System.out.println("test004 group 2");
    }
}
