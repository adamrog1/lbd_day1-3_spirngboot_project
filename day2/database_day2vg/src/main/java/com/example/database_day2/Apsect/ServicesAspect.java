package com.example.database_day2.Apsect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServicesAspect {
    Logger log = LoggerFactory.getLogger("com.example.database_day2.Services");
    @Around("execution(* com.example.database_day2.Services.*.*()) ")
    public Object aroundLogParameters(ProceedingJoinPoint joinPoint){
        Object val=joinPoint.getArgs();
        try{
            log.info("The arguments of method are: {}",val);
            val=joinPoint.getSignature();
            log.info("The return is: {}",val);
            val=joinPoint.proceed();
            log.info("Method done");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return val;
    }
}
