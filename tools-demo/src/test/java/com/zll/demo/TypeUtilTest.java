package com.zll.demo;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;
import com.zll.demo.model.User;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * 泛型类型的工具类
 */
public class TypeUtilTest {

    @Test
    public void test001(){

        Method setSal = ReflectUtil.getMethod(User.class, "setSal", String.class);

        Type returnType = TypeUtil.getReturnType(setSal);

        System.out.println(returnType);

        Class<?>[] clzs = TypeUtil.getParamClasses(setSal);

        Arrays.stream(clzs).forEach(clz-> System.out.println(clz));

    }


    @Test
    public void test002(){

    }


    @Test
    public void test003(){

    }


    @Test
    public void test004(){

    }

    @Test
    public void test005(){

    }

    @Test
    public void test006(){

    }

    @Test
    public void test007(){

    }

    @Test
    public void test008(){

    }

    @Test
    public void test009(){

    }

    @Test
    public void test010(){

    }
}
