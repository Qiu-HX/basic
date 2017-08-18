package com.pikaqiu.manage.web.logback;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * Created by user on 2017/8/14.
 */
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Pointcut("execution(* com.pikaqiu.manage.web.controller.*.*(..))")
    private void loggingOperation() {}

    @Before("loggingOperation()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("resource:   The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("loggingOperation()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        ModelAndView modelAndView = (ModelAndView) pjp.proceed();//执行该方法
        System.out.println("****************************************");
        System.out.println(modelAndView);
        System.out.println("****************************************");
        return modelAndView;
    }
}
