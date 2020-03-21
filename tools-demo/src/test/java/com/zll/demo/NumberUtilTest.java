package com.zll.demo;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class NumberUtilTest {

    @Test
    public void test001() {
        BigDecimal add = NumberUtil.add(1.1, 1.2, 2.1);
        System.out.println(add.doubleValue());
    }


    /**
     * @see java.text.DecimalFormat
     */
    @Test
    public void test002() {
        long c = 299792458;//光速
        String s = NumberUtil.decimalFormat(",###", c);
        System.out.println(s);
    }

    @Test
    public void test003() {
        String a = "1222";
        boolean number = NumberUtil.isNumber(a);
        System.out.println(number);

        String a2 = "1.23";
        boolean aDouble = NumberUtil.isDouble(a2);
        System.out.println(aDouble);

        boolean primes = NumberUtil.isPrimes(7);
        System.out.println(primes);

        boolean integer = NumberUtil.isInteger("1.2");
        System.out.println(integer);
    }

    @Test
    public void test004() {
        int[] ints = NumberUtil.generateRandomNumber(1, 20, 10);
        Arrays.stream(ints).forEach(i -> System.out.println(i));

        System.out.println("==================");

        Integer[] integers = NumberUtil.generateBySet(1, 10, 3);
        Arrays.stream(integers).forEach(i-> System.out.println(i));
    }

    @Test
    public void test005(){
        long factorial = NumberUtil.factorial(2);
        System.out.println(factorial);

        String s = NumberUtil.toStr(1243.4000);
        System.out.println(s);

        int compare = NumberUtil.compare(1, 2);
        System.out.println(compare);

        String binaryStr = NumberUtil.getBinaryStr(123456);

        System.out.println(binaryStr);


        int i = NumberUtil.binaryToInt(binaryStr);
        System.out.println(i);

        long sqrt = NumberUtil.sqrt(9);
        System.out.println(sqrt);

        int divisor = NumberUtil.divisor(10, 4);
        System.out.println(divisor);
    }
}
