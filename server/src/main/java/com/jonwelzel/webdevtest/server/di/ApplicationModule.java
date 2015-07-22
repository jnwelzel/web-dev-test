package com.jonwelzel.webdevtest.server.di;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.jonwelzel.webdevtest.server.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.di.interceptors.OnSave;
import com.jonwelzel.webdevtest.server.di.interceptors.OnSaveInterceptor;
import com.jonwelzel.webdevtest.server.persistence.daos.SkillDaoInterface;
import com.jonwelzel.webdevtest.server.persistence.daos.SkillDaoMockImpl;
import com.jonwelzel.webdevtest.server.persistence.daos.UserDaoInterface;
import com.jonwelzel.webdevtest.server.persistence.daos.UserDaoMockImpl;
import com.jonwelzel.webdevtest.server.services.SkillServiceImpl;
import com.jonwelzel.webdevtest.server.services.SkillServiceInterface;
import com.jonwelzel.webdevtest.server.services.UserServiceImpl;
import com.jonwelzel.webdevtest.server.services.UserServiceInterface;

/**
 * Created by jwelzel on 21/07/15.
 */
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        // DAOs
        bind(SkillDaoInterface.class).annotatedWith(MockDao.class).to(SkillDaoMockImpl.class);
        bind(UserDaoInterface.class).annotatedWith(MockDao.class).to(UserDaoMockImpl.class);

        // Services
        bind(SkillServiceInterface.class).to(SkillServiceImpl.class);
        bind(UserServiceInterface.class).to(UserServiceImpl.class);

        bindInterceptor(Matchers.any(), Matchers.annotatedWith(OnSave.class), new OnSaveInterceptor());
    }

}
