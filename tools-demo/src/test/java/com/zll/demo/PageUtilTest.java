package com.zll.demo;

import cn.hutool.core.util.PageUtil;
import org.junit.Test;

import java.util.Arrays;


public class PageUtilTest {

    /**
     * 将页码转化为开始位置和结束位置
     */
    @Test
    public void test001(){
        int[] ints = PageUtil.transToStartEnd(1, 10);
        Arrays.stream(ints).forEach(i-> System.out.println(i));

        int[] ints1 = PageUtil.transToStartEnd(3, 5);
        Arrays.stream(ints1).forEach(i-> System.out.println(i)
        );
    }


    @Test
    public void test002(){
        int pages = PageUtil.totalPage(10, 3);
        System.out.println(pages);
    }


    @Test
    public void test003(){
        //参数意义分别为：当前页、总页数、每屏展示的页数
        int[] rainbow = PageUtil.rainbow(5, 20, 6);

        Arrays.stream(rainbow).forEach(i-> System.out.println(i));

        //上一页 3 4 [5] 6 7 8 下一页
    }


}
