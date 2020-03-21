package com.zll.demo.service;

import com.zll.demo.dao.UserDao;
import com.zll.demo.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    @Lazy
    private UserDao userDao;

    public String getName(int userId) {
        //这个地方开始 mock
        User user = userDao.getById(userId);

        if (null == user) {
            return "";
        } else {
            return "offline_" + user.getName();
        }
    }
}
