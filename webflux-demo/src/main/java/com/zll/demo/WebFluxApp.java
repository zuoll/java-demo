package com.zll.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebFluxApp {
    public static void main(String[] args) {
        try {
            SpringApplication.run(WebFluxApp.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
