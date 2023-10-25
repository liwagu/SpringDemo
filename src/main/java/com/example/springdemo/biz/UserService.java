package com.example.springdemo.biz;


import com.example.springdemo.aop.Cache;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Cache
    public User getUserById(int id){
        User user = new User();
        user.setId(id);
        user.setUsername("name" + id); // 这里仅为模拟
        return user;
    }
    public String getUsernameById(int id){
        return getUserById(id).getUsername();
    }
}
