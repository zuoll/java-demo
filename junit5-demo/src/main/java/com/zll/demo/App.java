package com.zll.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
            String[] beanDefinitionNames = context.getBeanDefinitionNames();
            System.out.println(beanDefinitionNames.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
