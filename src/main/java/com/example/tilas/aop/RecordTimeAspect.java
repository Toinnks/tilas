package com.example.tilas.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class RecordTimeAspect {
//    @Around("execution(* com.example.tilas.controller.*.*(..))")
//    public Object recordTime(ProceedingJoinPoint joinPoint){
//        long start = System.currentTimeMillis();
//        Object result = null;
//        try {
//            result = joinPoint.proceed();
//        }catch (Throwable e){
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//
//        log.info("{}方法执行耗时：{}",joinPoint.getSignature(),end-start);
//
//        return result;
//    }

    @Around("execution(* com.example.tilas.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around---{}方法开始执行",joinPoint.getSignature());
        Object result = joinPoint.proceed();
        log.info("around---{}方法执行结束",joinPoint.getSignature());
        return result;
    }
    @Before("execution(* com.example.tilas.controller.*.*(..))")
    public void before(){
        log.info("before---方法开始执行");
    }
    @After("execution(* com.example.tilas.controller.*.*(..))")
    public void after(){
        log.info("after---方法执行结束");
    }
    @AfterReturning("execution(* com.example.tilas.controller.*.*(..))")
    public void afterReturning(){
        log.info("afterReturning---方法正常返回");
    }
    @AfterThrowing("execution(* com.example.tilas.controller.*.*(..))")
    public void afterThrowing(){
        log.info("afterThrowing---方法异常返回");
    }
}