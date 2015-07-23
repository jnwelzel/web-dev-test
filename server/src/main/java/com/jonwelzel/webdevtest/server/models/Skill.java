package com.jonwelzel.webdevtest.server.models;

import com.jonwelzel.webdevtest.server.persistence.AbstractBaseBean;

/**
 * Created by jwelzel on 21/07/15.
 */
public class Skill extends AbstractBaseBean {

    private String description;
    private Integer score;
    private SkillGroup skillGroup;

    public Skill() {
    }

    public Skill(String description, Integer score, SkillGroup group) {
        this.description = description;
        this.score = score;
        this.skillGroup = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public SkillGroup getSkillGroup() {
        return skillGroup;
    }

    public void setSkillGroup(SkillGroup skillGroup) {
        this.skillGroup = skillGroup;
    }
}
