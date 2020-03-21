package com.zll.demo;

import org.junit.Test;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * 重复性测试
 */
public class TestRepeat {

    @BeforeEach
    void beforeTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        Set<String> tags = testInfo.getTags();
        Method method = testInfo.getTestMethod().get();

        System.out.println("===========>" + totalRepetitions);
        System.out.println("===========>" + currentRepetition);
        System.out.println("===========>" + method.getName());
        tags.stream().forEach(tag -> System.out.println("===========>" + tag));
    }

    @RepeatedTest(5)
    @Tag("test-001")
    void test001() {
        System.out.println("test 001");
    }

    @Test
    @Tag("test-002")
    public void test002(){
        System.out.println("test 002");
    }
}
