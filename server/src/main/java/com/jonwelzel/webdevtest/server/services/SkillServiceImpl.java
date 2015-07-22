package com.jonwelzel.webdevtest.server.services;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.models.Skill;
import com.jonwelzel.webdevtest.server.persistence.daos.SkillDaoInterface;

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
