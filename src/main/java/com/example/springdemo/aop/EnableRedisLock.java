package com.example.springdemo.aop;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface EnableRedisLock {
    String LockKey();
    long expireTime() default 5;
    TimeUnit timeUint() default TimeUnit.MINUTES;
    int retryTimes() default 10;
}
