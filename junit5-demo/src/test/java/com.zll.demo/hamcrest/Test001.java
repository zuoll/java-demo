package com.zll.demo.hamcrest;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * 核心：anything,describedAs,is
 * 逻辑：allOf，anyOf，not
 * 对象：equalTo，hasToString，instanceOf，isCompatibleType，notNullValue，nullValue，sameInstance
 * Beans：hasProperty
 * 集合：array，hasEntry，hasKey，hasValue，hasItem，hasItems，hasItemInArray
 * 数字：closeTo，greaterThan，greaterThanOrEqualTo，lessThan，lessThanOrEqualTo
 * 字符：equalToIgnoringCase，equalToIgnoringWhiteSpace，containsString，endsWith，startsWith
 */
public class Test001 {

    // import static org.hamcrest.MatcherAssert.assertThat; import static org.hamcrest.Matchers.*

   //&&
    @Test
    void test001(){

        assertThat("myname",allOf(startsWith("my"), containsString("name")));
    }

    //both &&
    @Test
    void test002(){
        assertThat("myname", both(containsString("name")).and(containsString("me")));
    }

    //两者之一
    @Test
    void test003(){
        assertThat("myname",either(containsString("my"))
                .or(containsString("you")));
    }

    //每一项都必须满足
    @Test
    void test004(){
        assertThat(Arrays.asList("myname","mine"), everyItem(startsWith("m")));
    }


    //是否包含这个元素
    @Test
    void test005(){
        assertThat(Arrays.asList("my","mine"),hasItem("my"));
    }

    //包含多个元素

    @Test
    void test006(){
        assertThat(Arrays.asList("my","mine"),hasItems("my","mine"));
    }


    //is 类似equalTo

    @Test
    void test007(){
        assertThat("myname",is("myname"));
    }

    @Test
    void test008(){
        assertThat("myname", is(String.class));
    }

    //not 相当于！
    @Test
    void test009(){
        assertThat("myname",is(not("you")));
    }


    //notvalue 值为空
    @Test
    void test010(){
        String str = null;
        assertThat(str, is(nullValue()));
    }


    //字符串匹配
    @Test
    void test200(){
        assertThat("myname", containsString("name"));
        assertThat("myname", startsWith("my"));
        assertThat("myname", endsWith("name"));
        assertThat("", isEmptyOrNullString());
        assertThat("myname",equalTo("myname"));
        assertThat("MyName", equalToIgnoringCase("myname"));
        assertThat("   my name  ", equalToIgnoringWhiteSpace("my name"));

        //是否为其中之一
        assertThat("myname", isOneOf("myname","youname"));
        //是否为其成员
        assertThat("myname", isIn(new String[]{"myname","youname"}));
    }

    //数值比较

    @Test
    void test300(){
        assertThat(3.14, closeTo(3, 0.5));

        assertThat(new BigDecimal("3.14"), closeTo(new BigDecimal("3"), new BigDecimal(0.5)));


        //compareTo比较值
        assertThat(2, comparesEqualTo(2));


        //大于
        assertThat(2, greaterThan(1));

        //小于
        assertThat(0, lessThan(2));

        //>=
        assertThat(2,greaterThanOrEqualTo(2));

        //<=
        assertThat(0, lessThanOrEqualTo(2));
    }

    //集合比较
    @Test
    void test400(){
        // array: 数组长度相等且对应元素也相等

        assertThat(new Integer[]{1,2,3}, is(array(equalTo(1),equalTo(2),equalTo(3))));

        // hasItemInArray: 数组是否包含特定元素

        assertThat(new String[]{"my","you","his"}, hasItemInArray(startsWith("m")));

        //arrayContainingInAnyOrder， 顺序无关，长度要一致

        assertThat(new String[]{"you","me"}, arrayContainingInAnyOrder("me","you"));


        // arrayWithSize: 数组长度

        assertThat(new Integer[]{1,2,3}, arrayWithSize(3));

        //emptyArray: 空数组

        assertThat(new Integer[]{}, emptyArray());

        //hasSize: 集合大小

        assertThat(Arrays.asList(1,2,3),hasSize(equalTo(3)));

        //empty: 空集合

        assertThat(new ArrayList<>(), is(empty()));

        //  isIn: 是否为集合成员

        assertThat("myname", isIn(Arrays.asList("myname","youname")));

        //Map匹配
        Map<String, Object> maps = new HashMap<>();
        maps.put("key",123);
        maps.put("key2",1234);
        assertThat(maps, hasEntry("key", 123));


        //hasKey: key匹配

        assertThat(maps, hasKey("key"));

        // hasValue: value匹配

        assertThat(maps,hasValue(equalTo(123)));
    }

}

