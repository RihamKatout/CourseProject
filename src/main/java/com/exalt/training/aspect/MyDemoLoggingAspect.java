package com.exalt.training.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(public void addAccount())")
    private void beforeAdding(){}

    @Before("beforeAdding()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n ==> Hi before adding account :p");
    }
}
