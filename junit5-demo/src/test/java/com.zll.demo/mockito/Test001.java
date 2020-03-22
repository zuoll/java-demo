package com.zll.demo.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * 测试驱动开发，要求先写测试，后写实现
 */
public class Test001 {

    /**
     * 行为验证
     */
    @Test
    void test1() {
        List mock = mock(List.class);
        mock.add(1);
        mock.clear();

        //验证这两个行为是否发生过
        verify(mock).add(1);
        verify(mock).clear();
    }

    /**
     * 模拟我们所期望的结果
     */
    @Test
    void test2() {
        Iterator iterator = mock(Iterator.class);

        //预设第一次next 返回hello  其他都返回world;
        when(iterator.next()).thenReturn("hello").thenReturn("world");

        String res = iterator.next() + "," + iterator.next() + "," + iterator.next();

        assertEquals("hello,world,world", res);
    }


    /**
     * 预设测试异常
     */
    @Test
    void test3() throws IOException {
        OutputStream outputStream = mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        //预设,当流关闭时抛出异常
        doThrow(new IOException()).when(outputStream).close();

        //FIXME 在IDEA超过多个就可以使用静态导入了,否则会不fly import 去除掉
        Assertions.assertThrows(IOException.class, () -> {
            //开始do
            outputStream.close();
        });
    }


    /**
     * 模拟方法体抛出异常
     */
    @Test
    void test4() {
        List list = mock(List.class);
        //假设当list调用add(1) 时抛出异常
        doThrow(new RuntimeException()).when(list).add(1);

        //断言，当调用是不是会发生这个情况
        Assertions.assertThrows(RuntimeException.class, () -> {
            list.add(1);
        });
    }

    //使用注解来快速模拟对象
    @Mock
    private List mockList;

    //构造器初始化
    Test001() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test5() {
        mockList.add(1);

        //验证
        verify(mockList).add(1);
    }


    //参数匹配
    @Test
    void test6() {
        Comparable comparable = mock(Comparable.class);

        //预设根据不同的参数返回不同的结果，预设其实和junit5 的assume 类似
        when(comparable.compareTo("test")).thenReturn(1);
        when(comparable.compareTo("test2")).thenReturn(2);
        when(comparable.compareTo("test3")).thenReturn(3);

        //实际操作，断言
        assertEquals(1, comparable.compareTo("test"));
        assertEquals(2, comparable.compareTo("test2"));
        assertEquals(3, comparable.compareTo("test3"));
    }


    //自己期望的参数匹配
    @Test
    void test7() {
        List list = mock(List.class);

        when(list.get(anyInt())).thenReturn(1);

        when(list.contains(argThat(new IsValid()))).thenReturn(true);

        //执行后，断言
        assertTrue(list.contains(1));
        assertTrue(!list.contains(3));

        //
        assertEquals(1, list.get(1));
        assertEquals(1, list.get(9999));
    }



    class IsValid implements ArgumentMatcher<List>{

        @Override
        public boolean matches(List argument) {
            return argument.contains(1) || argument.contains(2);
        }
    }





}

