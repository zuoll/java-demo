package com.zll.demo;

import cn.hutool.core.date.*;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {


    @Test
    public void test001() {
        DateTime date = DateUtil.date();
        int hour = date.getField(DateField.HOUR);
        int minute = date.getField(DateField.MINUTE);
        int second = date.getField(DateField.SECOND);
        System.out.println(hour + "," + minute + "," + second);

        DateTime date1 = DateUtil.date(Calendar.getInstance());
        System.out.println(date1.getTime());
        DateTime date2 = DateUtil.date(System.currentTimeMillis());
        System.out.println(date2.getTime());
    }

    @Test
    public void test002() {
        String str = "2020-12-12";
        DateTime parse = DateUtil.parse(str);
        System.out.println(parse.toString());

        String str2 = "2020-12-12 12:21:21";
        DateTime parse1 = DateUtil.parse(str2);
        System.out.println(parse1.toString());

        String str3 = "2020/03/02 10:10:10";
        DateTime parse2 = DateUtil.parse(str3);
        System.out.println(parse2.toString());
    }

    @Test
    public void test003() {

        String dateStr = "2020-03-02";
        DateTime parse = DateUtil.parse(dateStr);
        System.out.println(parse.getTime());
        String format = DateUtil.format(new Date(), "yyyy/MM/dd");
        System.out.println(format);

        String s1 = DateUtil.formatDate(new Date());
        System.out.println(s1);

        String s2 = DateUtil.formatDateTime(new Date());
        System.out.println(s2);
    }


    @Test
    public void test004() {
        DateTime date = DateUtil.date();
        int year = DateUtil.year(date);
        int month = DateUtil.month(date);
        int day = DateUtil.dayOfMonth(date);
        System.out.println(year + "," + month + "," + day);

        //获取月份枚举
        Month monthEnum = DateUtil.monthEnum(date);
        System.out.println(monthEnum.name());
    }

    @Test
    public void test005() {
        String dateStr = "2020-02-03 17:55:22";
        DateTime parse = DateUtil.parse(dateStr);

        //获取一天的开始

        DateTime beginOfDay = DateUtil.beginOfDay(parse);
        //获取一天的结束

        DateTime endOfDay = DateUtil.endOfDay(parse);

        System.out.println(beginOfDay.toString());
        System.out.println(endOfDay.toString());
    }

    /**
     * 日期时间的偏移
     */
    @Test
    public void test006() {
        String dateStr = "2020-03-02 17:55:22";

        DateTime dateTime = DateUtil.parse(dateStr);

        DateTime offset = DateUtil.offset(dateTime, DateField.DAY_OF_MONTH, 2);

        System.out.println(offset);

        DateTime dateTime1 = DateUtil.offsetDay(dateTime, 3);
        System.out.println(dateTime1);

        DateTime dateTime2 = DateUtil.offsetHour(dateTime, -2);
        System.out.println(dateTime2);

    }

    /**
     * 简化版的偏移方法
     */
    @Test
    public void test008() {
        DateTime yesterday = DateUtil.yesterday();
        DateTime tomorrow = DateUtil.tomorrow();
        DateTime lastMonth = DateUtil.lastMonth();
        DateTime nextMonth = DateUtil.nextMonth();
        DateTime nextWeek = DateUtil.nextWeek();
        DateTime lastWeek = DateUtil.lastWeek();
        System.out.println(yesterday);
        System.out.println(tomorrow);
        System.out.println(lastMonth);
        System.out.println(nextMonth);
        System.out.println(lastWeek);
        System.out.println(nextWeek);
    }

    /**
     * 时间差
     */

    @Test
    public void test010() {
        String dateStr1 = "2020-02-03 12:12:12";
        String dateStr2 = "2020-02-10 15:15:10";
        DateTime start = DateUtil.parse(dateStr1);
        DateTime end = DateUtil.parse(dateStr2);

        //相差的天数
        long day = DateUtil.betweenDay(end, start, false);
        System.out.println(day);

//        格式化时间,可阅读的格式
        String s = DateUtil.formatBetween(start,end, BetweenFormater.Level.SECOND);
        System.out.println(s);

        Console.log(s);

    }


    /**
     *计时器
     */
    @Test
    public void test011() {

        TimeInterval timer = DateUtil.timer();
        try {
            Thread.sleep(2000 * 60);
            System.out.println("执行一个任务2minute");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long interval = timer.interval();
        System.out.println(interval);
        long minute = timer.intervalMinute();
        System.out.println(minute);
    }

    @Test
    public void test012(){
        int age = DateUtil.ageOfNow("1992-04-01");
        System.out.println(age);

        boolean leapYear = DateUtil.isLeapYear(2020);
        System.out.println(leapYear);
    }

    @Test
    public void test013(){
        Date date = new Date();
        DateTime dateTime = new DateTime(date);
        System.out.println(dateTime);

        DateTime now = DateTime.now();
        System.out.println(now);
        DateTime of = DateTime.of(date);
        System.out.println(of);
    }

    @Test
    public void test014(){
        DateTime dateTime = new DateTime("2020-03-02 12:12:12",DatePattern.NORM_DATE_FORMAT);

        System.out.println(dateTime);

        int year = dateTime.year();
        System.out.println(year);

        int month = dateTime.month();
        System.out.println(month);
        System.out.println(dateTime.monthEnum().name());

        int day = dateTime.dayOfMonth();
        System.out.println(day);

        String name = dateTime.quarterEnum().name();
        System.out.println(name);

    }

    @Test
    public void test015(){
        DateTime dateTime = new DateTime("2020-03-02 12:21:12",DatePattern.NORM_DATE_FORMAT);
        System.out.println(dateTime.toString());
        System.out.println(dateTime.toString("yyyy/MM/dd"));
    }

}
