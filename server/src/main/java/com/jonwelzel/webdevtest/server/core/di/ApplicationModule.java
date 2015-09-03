package com.jonwelzel.webdevtest.server.core.di;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.servlet.RequestScoped;
import com.jonwelzel.webdevtest.server.core.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.core.di.binding.RedisDao;
import com.jonwelzel.webdevtest.server.core.di.interceptors.OnSave;
import com.jonwelzel.webdevtest.server.core.di.interceptors.OnSaveInterceptor;
import com.jonwelzel.webdevtest.server.core.di.interceptors.OnUpdate;
import com.jonwelzel.webdevtest.server.core.di.interceptors.OnUpdateInterceptor;
import com.jonwelzel.webdevtest.server.core.services.CandidateServiceImpl;
import com.jonwelzel.webdevtest.server.core.services.CandidateServiceInterface;
import com.jonwelzel.webdevtest.server.core.services.EmailServiceImpl;
import com.jonwelzel.webdevtest.server.core.services.EmailServiceInterface;
import com.jonwelzel.webdevtest.server.core.services.SessionServiceImpl;
import com.jonwelzel.webdevtest.server.core.services.SessionServiceInterface;
import com.jonwelzel.webdevtest.server.core.services.SkillServiceImpl;
import com.jonwelzel.webdevtest.server.core.services.SkillServiceInterface;
import com.jonwelzel.webdevtest.server.jdbi.daos.CandidateDaoInterface;
import com.jonwelzel.webdevtest.server.jdbi.daos.CandidateDaoMockImpl;
import com.jonwelzel.webdevtest.server.jdbi.daos.SessionDaoInterface;
import com.jonwelzel.webdevtest.server.jdbi.daos.SessionDaoRedisImpl;
import com.jonwelzel.webdevtest.server.jdbi.daos.SkillDaoInterface;
import com.jonwelzel.webdevtest.server.jdbi.daos.SkillDaoMockImpl;

/**
 * Created by jwelzel on 21/07/15.
 */
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        // DAOs
        bind(SkillDaoInterface.class).annotatedWith(MockDao.class).to(SkillDaoMockImpl.class);
        bind(CandidateDaoInterface.class).annotatedWith(MockDao.class).to(CandidateDaoMockImpl.class);
        bind(SessionDaoInterface.class).annotatedWith(RedisDao.class).to(SessionDaoRedisImpl.class).in(RequestScoped.class);

        // Services
        bind(SkillServiceInterface.class).to(SkillServiceImpl.class);
        bind(CandidateServiceInterface.class).to(CandidateServiceImpl.class);
        bind(EmailServiceInterface.class).to(EmailServiceImpl.class);
        bind(SessionServiceInterface.class).to(SessionServiceImpl.class);

        // Method interceptors
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(OnSave.class), new OnSaveInterceptor());
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(OnUpdate.class), new OnUpdateInterceptor());
    }

}
