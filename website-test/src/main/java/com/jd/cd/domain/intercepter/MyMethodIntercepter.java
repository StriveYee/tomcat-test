package com.jd.cd.domain.intercepter;

import org.aopalliance.intercept.MethodInvocation;

public class MyMethodIntercepter implements org.aopalliance.intercept.MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("***proxy run***");
        return methodInvocation.proceed();
    }

}
