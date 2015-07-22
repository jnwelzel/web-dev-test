package com.jonwelzel.webdevtest.server.di;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.jonwelzel.webdevtest.server.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.di.interceptors.OnSave;
import com.jonwelzel.webdevtest.server.di.interceptors.OnSaveInterceptor;
import com.jonwelzel.webdevtest.server.di.interceptors.OnUpdate;
import com.jonwelzel.webdevtest.server.di.interceptors.OnUpdateInterceptor;
import com.jonwelzel.webdevtest.server.persistence.daos.CandidateDaoInterface;
import com.jonwelzel.webdevtest.server.persistence.daos.CandidateDaoMockImpl;
import com.jonwelzel.webdevtest.server.persistence.daos.SkillDaoInterface;
import com.jonwelzel.webdevtest.server.persistence.daos.SkillDaoMockImpl;
import com.jonwelzel.webdevtest.server.services.CandidateServiceImpl;
import com.jonwelzel.webdevtest.server.services.CandidateServiceInterface;
import com.jonwelzel.webdevtest.server.services.SkillServiceImpl;
import com.jonwelzel.webdevtest.server.services.SkillServiceInterface;

/**
 * Created by jwelzel on 21/07/15.
 */
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        // DAOs
        bind(SkillDaoInterface.class).annotatedWith(MockDao.class).to(SkillDaoMockImpl.class);
        bind(CandidateDaoInterface.class).annotatedWith(MockDao.class).to(CandidateDaoMockImpl.class);

        // Services
        bind(SkillServiceInterface.class).to(SkillServiceImpl.class);
        bind(CandidateServiceInterface.class).to(CandidateServiceImpl.class);

        // Method interceptors
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(OnSave.class), new OnSaveInterceptor());
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(OnUpdate.class), new OnUpdateInterceptor());
    }

}
