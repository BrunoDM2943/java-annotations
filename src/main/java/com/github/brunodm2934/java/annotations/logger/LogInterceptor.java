package com.github.brunodm2934.java.annotations.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

@Interceptor @Log
public class LogInterceptor {

    @AroundInvoke
    private Object handler(InvocationContext context) throws Exception {
        Method method = context.getMethod();
        System.out.println(String.format("Calling %s with the following parameter %s", method.getName(), context.getParameters()[0]));
        Object returnValue = context.proceed();
        System.out.println(String.format("Returned value=%s", returnValue));
        return returnValue;
    }
}
