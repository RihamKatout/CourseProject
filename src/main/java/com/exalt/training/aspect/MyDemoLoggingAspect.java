package com.exalt.training.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(public void addAccount())")
    private void beforeAdding(){}

    @Before("beforeAdding()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n ==> Hi before adding account :p");
    }

    @Around("beforeAdding()")
    public Object aroundAddAccountAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("=====> duration = " + (end - begin));
        return result;
    }

    @AfterReturning(pointcut = "execution(java.util.List<String> findAccounts())", returning = "result")
    public void afterFindingAccounts(JoinPoint joinPoint, List<String> result){
        System.out.println("Afteeeeeeeeeer");
        for(String str : result)
            System.out.println(str);
    }
}
