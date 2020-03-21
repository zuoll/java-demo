package com.zll.demo;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * 动态测试
 */
public class TestDynamic {


    @TestFactory
    Collection<DynamicTest> test001() {
        return Arrays.asList(DynamicTest.dynamicTest("first test", () -> Assertions.assertTrue(true)),

                DynamicTest.dynamicTest("second test", () -> Assertions.assertEquals(2, 2)));
    }


    @TestFactory
    Stream<DynamicNode> test002() {
        return Stream.of("A", "B", "C").map(input -> DynamicContainer.dynamicContainer("contain" + input, Stream.of(DynamicTest.dynamicTest("not null", () -> {
            System.out.println(input);
            Assertions.assertNotNull(input);
        }))));
    }
}
