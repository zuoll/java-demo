package com.zll.demo.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * 通过spy 来监控真实的对象
 */
public class Test002 {

    //junit4 的方法必须是public
    @Test
    void test1() {
        List list = spy(new ArrayList());
        List list2 = spy(new ArrayList());

        assertEquals(0, list.size());
        assertEquals(0, list2.size());

        A a = mock(A.class);
        //假设
        when(a.doSomething(anyInt())).thenCallRealMethod();

        //实际do, 断言
        assertEquals(100, a.doSomething(100));
    }

    class A {
        public int doSomething(int num) {
            return num;
        }
    }
    //@formatter:off
    @Test
    void test2() {
                System.out.println(111);
                    System.out.println(111);
                        System.out.println(111);
                            System.out.println(111);
    }
    //@formatter:off
    //@formatter:on


    //重置所有的mock
    @Test
    void test3(){
        List list = mock(List.class);

        //assume
        when(list.size()).thenReturn(10);

        assertEquals(10, list.size());
        // 操作2
        list.add(1);

        //重置mock
        reset(list);

        //断言
        verify(list).add(1);
        assertEquals(10, list.size());
    }


    //断言调用次数

    @Test
    void  test4(){
        List list = mock(List.class);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        verify(list,times(2)).add(1);
        verify(list,times(1)).add(2);
        verify(list,never()).add(4);
        //至少调用一次
        verify(list,atLeast(2)).add(1);
        //最多调用2次
        verify(list,atMost(1)).add(2);
    }

    //验证调用顺序
    @Test
    void test5(){
        List list1  = mock(List.class);
        List list2  = mock(List.class);

        list1.add(1);
        list2.add("hello");
        list1.add(2);
        list2.add("world");

        InOrder inOrder = inOrder(list1, list2);
        inOrder.verify(list1).add(1);
        inOrder.verify(list2).add("hello");
        inOrder.verify(list1).add(2);
        inOrder.verify(list2).add("world");
    }

    //断言对象没有互动
    @Test
    void test6(){
        List list = mock(List.class);
        List list2 = mock(List.class);
        List list3 = mock(List.class);
        list.add(1);
        verify(list).add(1);
        verify(list2, never()).add(2);
        //从创建没有做任何操作
        verifyZeroInteractions(list3);
    }

    //验证连续调用
    @Test
    void test7(){
        List list = mock(List.class);
        //如果分开，会覆盖
        when(list.get(0)).thenReturn(1);
        when(list.get(0)).thenReturn(2);
        //当多次调用get(1),第一次返回1，第二次返回2，第三次抛出异常
        when(list.get(1)).thenReturn(1).thenReturn(2).thenThrow(new RuntimeException());

        //断言
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(1));
        assertThrows(RuntimeException.class,()->{
           list.get(1) ;
        });
    }
}
