package com.zll.demo;

import com.zll.demo.model.User;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class Test3 {

    @Test
    void standardAssert() {

        assertEquals(2, 2);
        assertEquals(4, 4, " 4 is equal 4");

        assertTrue('a' < 'b');
    }

    @Test
    void groupAssert() {

        User user = User.builder().id(1001).name("zs").age(22).build();
        assertAll("user"
                , () -> assertEquals(1001, user.getId())
                , () -> assertEquals("zs", user.getName())
                , () -> assertEquals(22, user.getAge()));

    }

    @Test
    void dependAssert() {
        User user = User.builder().id(1002).name("lao-wang").age(33).build();
        assertAll("user"
                , () -> {
                    String name = user.getName();
                    assertNotNull(name);

                    //only execute it previous is valid
                    assertAll("name"
                            , () -> {
                                assertTrue(name.startsWith("aaaalao"));
                            }
                            , () -> {
                                assertTrue(name.endsWith("wang"));
                            });

                }
                , () -> {
                    int age = user.getAge();
                    assertEquals(33, age);
                });

    }


    @Test
    void exceptionTest(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });

        assertEquals("a message", exception.getMessage());
    }

    @Test
    void timeOutException(){
        assertTimeout(Duration.ofMillis(2),()->{
            System.out.println("2 minute execute");
        });
    }


    @Test
    void timeOutWithResult(){
        String s = assertTimeout(Duration.ofMillis(2), () -> "a result");

        assertEquals("a result", s);
    }

    @Test
    void test001(){
        System.out.println(LocalDateTime.now());
        String s = assertTimeout(Duration.ofSeconds(10), Test3::greeting);
        assertEquals("hello world", s);
    }


    private static String greeting(){
        try {
            Thread.sleep(10000);//10s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now());
        return "hello world";
    }
}
