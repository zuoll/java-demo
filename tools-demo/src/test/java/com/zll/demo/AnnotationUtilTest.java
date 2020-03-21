package com.zll.demo;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.map.MapUtil;
import com.zll.demo.model.Pk;
import com.zll.demo.model.User;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;

public class AnnotationUtilTest {

    public static void main(String[] args) {
        Annotation[] annotations = AnnotationUtil.getAnnotations(User.class, true);

        Arrays.stream(annotations).forEach(anno-> System.out.println(anno));
    }
}
