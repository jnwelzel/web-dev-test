package com.jonwelzel.webdevtest.server.core.di.interceptors;

import com.jonwelzel.webdevtest.server.api.BaseBean;
import com.jonwelzel.webdevtest.server.core.security.PasswordHash;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Date;

/**
 * Created by jwelzel on 22/07/15.
 */
public class OnSaveInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        BaseBean bean = (BaseBean) invocation.getArguments()[0];
        bean.setDateCreated(new Date());
        bean.setDateUpdated(new Date());
        bean.setId(PasswordHash.createSimpleHash());
        return invocation.proceed();
    }

}
