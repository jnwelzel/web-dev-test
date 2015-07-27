package com.jonwelzel.webdevtest.server.core.services;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.core.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.api.Skill;
import com.jonwelzel.webdevtest.server.jdbi.daos.SkillDaoInterface;

import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class SkillServiceImpl implements SkillServiceInterface {

    private final SkillDaoInterface skillDao;

    @Inject
    public SkillServiceImpl(@MockDao SkillDaoInterface skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillDao.findAll();
    }

}
