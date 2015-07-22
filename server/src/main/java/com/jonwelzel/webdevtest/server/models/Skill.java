package com.jonwelzel.webdevtest.server.models;

import com.jonwelzel.webdevtest.server.persistence.AbstractBaseBean;

/**
 * Created by jwelzel on 21/07/15.
 */
public class Skill extends AbstractBaseBean {

    private String description;
    private Integer score;

    public Skill() {
    }

    public Skill(String description, Integer score) {
        this.description = description;
        this.score = score;
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
}
