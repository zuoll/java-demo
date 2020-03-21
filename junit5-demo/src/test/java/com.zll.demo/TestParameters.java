package com.zll.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 參數化測試
 */
public class TestParameters {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 6})
    void test001(int argument) {

        System.out.println(argument);
        assertTrue(argument > 0 && argument < 10);
    }


    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void test002(TimeUnit timeUnit) {
        System.out.println(timeUnit);
        assertNotNull(timeUnit);
    }


    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    void test003(TimeUnit timeUnit) {
        System.out.println(timeUnit);
        EnumSet<TimeUnit> set = EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS);
        assertTrue(set.contains(timeUnit));
    }

    //排除模式
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.EXCLUDE, names = {"HOURS", "DAYS"})
    void test004(TimeUnit timeUnit) {
        System.out.println(timeUnit);
        EnumSet<TimeUnit> set = EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS);
        assertFalse(set.contains(timeUnit));
        System.out.println(timeUnit.name().length());
    }

    //方法作为数据源

    @ParameterizedTest
    @MethodSource("stringProvider")
    void staticMethodSource(String argument) {
        System.out.println(argument);
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }


    //自动搜索
    @ParameterizedTest
    @MethodSource("range")
    void test005(int argument) {
        System.out.println(argument);
        assertNotNull(argument);
    }

    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }

    //多个参数
    @ParameterizedTest
    @MethodSource("stringArgumentProvider")
    void test006(String str, int num, List<Integer> list) {
        System.out.println(str + "," + num + "," + list);
        assertEquals(3, str.length());
        assertTrue(num >= 1 && num <= 2);
        assertEquals(3, list.size());

    }

    static Stream<Arguments> stringArgumentProvider() {
        return Stream.of(Arguments.of("foo", 1, Arrays.asList(1, 2, 3))
                , Arguments.of("bar", 2, Arrays.asList(11, 22, 33)));
    }

    //csvSource

    @ParameterizedTest
    @CsvSource({"foo, 1", "bar, 2"})
    void test006(String first, int second) {
        System.out.println(first + "," + second);
        assertNotNull(first);
        assertTrue(second >= 1 && second <= 2);
    }


    //参数聚合

    @ParameterizedTest
    @CsvSource({"zs,22,F,1994-12-12", "lisi, 33, M, 1992-12-12"})
    void parameterAggr(ArgumentsAccessor argumentsAccessor) {
        System.out.println(argumentsAccessor.getString(0));
        System.out.println(argumentsAccessor.getString(1));
        System.out.println(argumentsAccessor.get(2, Gender.class));
        System.out.println(argumentsAccessor.get(3, LocalDate.class));
    }

    enum Gender{
        F, M;
    }

}
