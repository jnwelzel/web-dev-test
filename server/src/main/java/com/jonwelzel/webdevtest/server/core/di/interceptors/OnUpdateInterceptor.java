package com.jonwelzel.webdevtest.server.core.di.interceptors;

import com.jonwelzel.webdevtest.server.jdbi.BaseBean;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Date;

/**
 * Created by jwelzel on 22/07/15.
 */
public class OnUpdateInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        BaseBean bean = (BaseBean) invocation.getArguments()[0];
        bean.setDateUpdated(new Date());
        return invocation.proceed();
    }

}
