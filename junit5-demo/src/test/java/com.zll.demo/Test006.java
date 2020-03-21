package com.zll.demo;

import com.zll.demo.anno.TestOnWin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

/**
 * 按条件执行测试用例
 */
public class Test006 {

    //os condition

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void test001(){
        System.out.println("test on window");
    }


    @EnabledOnOs(OS.LINUX)
    @Test
    void test002(){
        System.out.println("test on linux");
    }


    @TestOnWin
    void test003(){
        System.out.println("test on window 003");
    }


    //jre condition

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void test004(){
        System.out.println("java 8 runtime");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_10)
    void test005(){
        System.out.println("java 10 runtime");
    }


    //system properties

    @Test
    @EnabledIfSystemProperty(named = "os.arch",matches = "amd64")
    void test006(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


    @Test
    @EnabledIfEnvironmentVariable(named = "spring.profile",matches = "dev")
    void test007(){
        System.out.println("dev");
    }


    @Test
    @EnabledIf("2==2")
    void test008(){
        System.out.println("enable if ");
    }
}
