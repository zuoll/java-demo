package com.zll.demo.tt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {

        System.out.println("tearDown");
    }

    @Test
    public void getId() {

        System.out.println("getId");

        int id = 10001;
        assertTrue(id==10001);
    }

    @Test
    public void setId() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getAge() {
    }

    @Test
    public void setAge() {
    }
}