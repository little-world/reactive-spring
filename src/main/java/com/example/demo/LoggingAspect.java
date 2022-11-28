package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


//    @Before("execution(* com.example.demo.*.Hello*.*(..))")
//    public void before(JoinPoint joinPoint) {
//        //Advice
//        logger.info(" in hello service ");
//        logger.info(" Allowed execution for {} , {}", joinPoint, joinPoint.getArgs());
//    }

//    @AfterReturning(value = "execution(* com.example.demo.controller.Hello*.*(..)))",
//            returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result) {
//        logger.info("{} returned with value {}", joinPoint, result);
//    }


    @Around("@annotation(com.example.demo.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        var result = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);

        return result;
    }


}
