package com.zll.demo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.zll.demo.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ObjectUtilTest {

    @Test
    public void test001(){
        int a = 1;
        boolean basicType = ObjectUtil.isBasicType(a);
        System.out.println(basicType);
    }


    @Test
    public void test002(){

        //实现序列化接口
        User user = new User();
        user.setId(1001);
        user.setName("zs");
        user.setAge(22);
        user.setSal("2W");
        byte[] serialize = ObjectUtil.serialize(user);

        Object deserialize = ObjectUtil.deserialize(serialize);

        User uu = (User) deserialize;

        System.out.println(uu.getId()+","+uu.getName()+","+uu.getSal());
    }


    /**
     * 对象判断是否为空
     */

    @Test
    public void test003(){

        String s = "";

        System.out.println(ObjectUtil.isNull(s));

        System.out.println(StrUtil.isEmpty(s));

        List<String> list  = new ArrayList<>(1);

        System.out.println(ObjectUtil.isNull(list));
        System.out.println(CollUtil.isEmpty(list));


        Iterator<String> iterator = list.iterator();

        System.out.println(ObjectUtil.isNull(iterator));

    }


    /**
     * 对象是否包含元素
     */
    @Test
    public void test004(){

        User user  =  null;
        User user1 = Objects.requireNonNull(user);
        System.out.println(user1==null);
    }

}
