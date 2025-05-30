package com.abid.sinkingship.customerInterceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyCustomInterceptorAOP {

    @Around("@annotation(com.abid.sinkingship.customAnnotations.MyCustomAnnotation)")
    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("MyCustomInterceptorAOP invoke before method");

        joinPoint.proceed();

        System.out.println("MyCustomInterceptorAOP proceed after method");

    }


}
