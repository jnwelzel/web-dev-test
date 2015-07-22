package com.jonwelzel.webdevtest.server.persistence.daos;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.models.Skill;
import com.jonwelzel.webdevtest.server.persistence.InMemoryStore;

import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class SkillDaoMockImpl implements SkillDaoInterface {

    private InMemoryStore store;

    @Inject
    public SkillDaoMockImpl(InMemoryStore store) {
        this.store = store;
    }

    @Override
    public List<Skill> findAll() {
        return store.getSkills();
    }

    @Override
    public Skill findById(String id) {
        return null;
    }

    @Override
    public Skill save(Skill obj) {
        return null;
    }

    @Override
    public Skill update(Skill obj) {
        return null;
    }

    @Override
    public Skill delete(Skill obj) {
        return null;
    }

}
