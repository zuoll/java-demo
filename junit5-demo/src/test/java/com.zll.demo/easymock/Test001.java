package com.zll.demo.easymock;

import com.zll.demo.App;
import com.zll.demo.dao.UserDao;
import com.zll.demo.model.User;
import com.zll.demo.service.UserService;
import org.easymock.EasyMock;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Field;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = App.class)
@DisplayName("spring-junit5")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test001 {


    @Autowired
    private UserService userService;

    private UserDao userDaoMock;

    private User userMock;

    //在所有测试方法前执行，只执行一次
    @BeforeAll
    void setUp() throws Exception{
        System.out.println("setUp ....");

        userDaoMock = EasyMock.createMock(UserDao.class);

        userMock = EasyMock.createMock(User.class);

        //mock 注入被测试对象

        Field userDaoField = userService.getClass().getDeclaredField("userDao");

        userDaoField.setAccessible(true);

        userDaoField.set(userService, userDaoMock);
    }


    @Test
    void test001(){
        System.out.println(userService);
    }

    @Test
    void test002(){
        //设置mock 的期望值
        EasyMock.expect(userMock.getName()).andReturn("test-name");
        EasyMock.expect(userDaoMock.getById(1)).andReturn(userMock);

        //mock 对象的replay(重播)

        EasyMock.replay(userDaoMock);
        EasyMock.replay(userMock);

        //断言
        Assertions.assertTrue(userService.getName(1)
                .equals("offline_test-name"));

        //验证mock 对象是否被调用
        EasyMock.verify(userMock);
        EasyMock.verify(userDaoMock);
    }



    @AfterAll
    void tearDown(){
        System.out.println("after tear down");
        userDaoMock = null;
        userMock = null;
    }



}
