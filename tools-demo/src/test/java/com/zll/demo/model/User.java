package com.zll.demo.model;


import java.io.Serializable;

public class User implements Serializable {

    @Pk(value = "pk_id")
    private int id;
    private String name;
    private int age;

    private transient  String sal;


    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
