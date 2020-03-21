package com.zll.demo;

import com.google.common.base.MoreObjects;
import com.zll.demo.model.User;
import org.junit.Test;

public class ToStringHelperTest {

    @Test
    public void test001(){
        String s = MoreObjects.toStringHelper(this).toString();
        System.out.println(s);
    }

    @Test
    public void test002(){
        String s = MoreObjects.toStringHelper(User.builder().name("zs").age(22).build()).toString();
        System.out.println(s);
    }
}
