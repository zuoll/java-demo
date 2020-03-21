package com.zll.demo;

import org.junit.jupiter.api.*;

@DisplayName("test-100-demo")
public class Test100 {

    Test100(TestInfo testInfo) {
        System.out.println("construct....");
        Assertions.assertEquals("test-100-demo", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        System.out.println("init");
        String displayName = testInfo.getDisplayName();
        Assertions.assertTrue("test-001".equals(displayName)
        || "test-002".equals(displayName));
    }


    @Test
    @DisplayName("test-001")
    void test001() {
        System.out.println("test 001");
    }

    @Test
    @DisplayName("test-002")
    void test002() {
        System.out.println("test 002");
    }

}
