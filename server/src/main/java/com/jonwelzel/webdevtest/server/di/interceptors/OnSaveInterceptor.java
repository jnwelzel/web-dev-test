package com.jonwelzel.webdevtest.server.di.interceptors;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by jwelzel on 22/07/15.
 */
public class OnSaveInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("OnSaveInterceptor.invoke");
        return invocation.proceed();
    }

}
