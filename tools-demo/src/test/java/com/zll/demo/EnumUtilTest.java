package com.zll.demo;

import cn.hutool.core.util.EnumUtil;
import com.zll.demo.model.TestEnum;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;

public class EnumUtilTest {


    @Test
    public void test001(){

        List<String> names = EnumUtil.getNames(TestEnum.class);
        names.stream().forEach(n-> System.out.println(n));

        LinkedHashMap<String, TestEnum> enumMap = EnumUtil.getEnumMap(TestEnum.class);

        System.out.println(enumMap.get("test11"));

    }

}
