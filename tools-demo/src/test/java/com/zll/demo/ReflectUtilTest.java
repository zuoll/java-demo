package com.zll.demo;

import cn.hutool.core.util.ReflectUtil;
import com.zll.demo.model.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class ReflectUtilTest {

    @Test
    public void test001(){

        Field[] fields = ReflectUtil.getFields(User.class);


        Arrays.stream(fields).forEach(f-> System.out.println(f.getName()));
    }


    @Test
    public void test002(){
        Set<String> methodNames = ReflectUtil.getMethodNames(User.class);
        methodNames.forEach(m-> System.out.println(m));
    }


    @Test
    public void test003(){

        Method getSal = ReflectUtil.getMethod(User.class, "setSal", String.class);
        System.out.println(getSal.toString());
    }
}
