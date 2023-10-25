package com.example.springdemo.aop;

import com.example.springdemo.biz.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CacheAspect {
    private Map<Integer, User> cache = new HashMap<>();

    @Pointcut("@annotation(com.example.springdemo.aop.Cache)")
    public void cachePointcut() {}

    @Around("cachePointcut()")
    public Object aroundCache(ProceedingJoinPoint joinPoint) throws Throwable {
        Integer id = (Integer) joinPoint.getArgs()[0];

        if (cache.containsKey(id)) {
            return cache.get(id);
        }

        User result = (User) joinPoint.proceed();

        if (result != null) {
            cache.put(id, result);
        }
        return result;
    }
}
