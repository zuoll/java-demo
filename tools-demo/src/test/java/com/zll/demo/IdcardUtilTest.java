package com.zll.demo;

import cn.hutool.core.util.IdcardUtil;
import org.junit.Test;

import java.lang.reflect.GenericArrayType;

/**
 * 现在支持大陆15位、18位身份证，港澳台10位身份证
 *
 */
public class IdcardUtilTest {

    @Test
    public void test001(){
        String str = "420923199204074910";
        System.out.println(str.length());
        boolean validCard = IdcardUtil.isValidCard(str);
        System.out.println(validCard);

        String birthByIdCard = IdcardUtil.getBirthByIdCard(str);
        System.out.println(birthByIdCard);

        int age = IdcardUtil.getAgeByIdCard(str);
        System.out.println(age);

        int genderByIdCard = IdcardUtil.getGenderByIdCard(str);
        System.out.println(genderByIdCard);

        String provinceByIdCard = IdcardUtil.getProvinceByIdCard(str);
        System.out.println(provinceByIdCard);

    }
}
