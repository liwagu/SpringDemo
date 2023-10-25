package com.example.springdemo;

import com.example.springdemo.biz.UserLogic;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLogicTest {

    @Resource
    private UserLogic userLogic;

    @Test
    public void testTestAop() {
        userLogic.testAop();
    }
}
