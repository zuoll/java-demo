package com.zl.boot.controller;

import com.zl.boot.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/get")
    public String get(int id) {
        return "ok," + id;
    }

    @GetMapping("/get2")
    public String get2(int id) {
        return "ok2," + id;
    }

    @PostMapping("/save/user")
    public User saveUser(int id, String userName) {
        User u = new User();
        u.setId(id);
        u.setName(userName);
        u.setCreateDate(LocalDate.now());
        return u;
    }
}
