package com.zll.demo;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface Test101 {

    @BeforeEach
    default void bfClassTest(){
        System.out.println("before each");
    }

    @AfterEach
    default void afClassTest(){
        System.out.println("after each");
    }

    @BeforeAll
    default void bfAllTest(){
        System.out.println("before all");
    }


    @AfterAll
    default void afAlltest(){
        System.out.println("after all");
    }
}

