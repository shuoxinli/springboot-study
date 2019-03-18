package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void selectAll() {
        List<User> userList = userService.selectAll();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void getOne() {
        User user = userService.getOne(1L);
        System.out.println(user);
    }

    @Test
    public void delete() {
        userService.delete(3L);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUserName("程序员");
        user.setUserId(4L);
        user.setMobile("12345678911");
        user.setPassword("123456");
        user.setAvatar("1.jpg");
    }

    @Test
    public void update() {
        User user= userService.getOne(3L);
        user.setAvatar("66");
        userService.update(user);
    }
}