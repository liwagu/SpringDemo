package com.example.springdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.concurrent.TimeUnit;

@Aspect
public class RedisLockAspect {
    // Around After Before
    @Around(value = "@annotation(com.example.springdemo.aop.EnableRedisLock)")
    public void handleRedisLock(ProceedingJoinPoint joinPoint) throws Throwable {
        EnableRedisLock redisLock = ((MethodSignature) joinPoint.getSignature())
                .getMethod()
                .getAnnotation(EnableRedisLock.class);
        String lockKey = redisLock.LockKey();
        long expireTime = redisLock.expireTime();
        TimeUnit timeUnit = redisLock.timeUint();
        int retryTimes = redisLock.retryTimes();

        if (tryLock(lockKey, expireTime, timeUnit, retryTimes)) {
            try {
                // 获取锁成功继续执行业务逻辑
                joinPoint.proceed();
            } finally {
                releseLock();
            }
        }
    }
// todo 分布式锁todo

}
