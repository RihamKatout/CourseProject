package com.exalt.training.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(public void addAccount())")
    private void beforeAdding(){}

    @Before("beforeAdding()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n ==> Hi before adding account :p");
    }

    @AfterReturning(pointcut = "execution(java.util.List<String> findAccounts())", returning = "result")
    public void afterFindingAccounts(JoinPoint joinPoint, List<String> result){
        System.out.println("Afteeeeeeeeeer");
        for(String str : result)
            System.out.println(str);
    }
}
