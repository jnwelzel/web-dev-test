package com.jonwelzel.webdevtest.server.models;

import com.jonwelzel.webdevtest.server.persistence.AbstractBaseBean;

/**
 * Created by jwelzel on 21/07/15.
 */
public class Skill extends AbstractBaseBean {

    private String description;
    private Integer level = 0;

    public Skill() {
    }

    public Skill(String description, Integer level) {
        this.description = description;
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
