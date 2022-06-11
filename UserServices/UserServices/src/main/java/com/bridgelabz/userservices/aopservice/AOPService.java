package com.bridgelabz.userservices.aopservice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AOPService {


    @Before("execution(* com.bridgelabz.userservices.controller.UserController.*(..))")
    public void logBeforeV1(JoinPoint joinPoint) {
        log.info("Initiating API : " + joinPoint.getSignature().getName() + " ");
    }


    @After("execution(* com.bridgelabz.userservices.controller.UserController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("API successfully Executed : " + joinPoint.getSignature().getName() + " ");
    }


    @After("execution(* com.bridgelabz.userservices.controller.UserController.*(..))")
    public void logAfterAndSaveArgs(JoinPoint joinPoint) {
        log.info("After : " + Arrays.toString(joinPoint.getArgs()));
    }
}
