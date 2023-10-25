package com.example.springdemo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserLogic {
    @Resource
    private UserService userService;

    public void testAop() {
        userService.getUserById(1);   // 第一次查询
        userService.getUsernameById(1);  // 第二次查询
    }

//    public static void main(String[] args) {
//        UserLogic userLogic = new UserLogic();
//        userLogic.testAop();
//    }
}
