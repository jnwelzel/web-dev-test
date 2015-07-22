package com.jonwelzel.webdevtest.server.models;

import com.jonwelzel.webdevtest.server.persistence.AbstractBaseBean;

import java.util.Date;
import java.util.List;

/**
 * Created by jwelzel on 21/07/15.
 */
public class User extends AbstractBaseBean {

    private String name;
    private String email;
    private List<Skill> skills;
    private Date lastTest;

    User() {

    }

    public User(String name, String email, List<Skill> skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Date getLastTest() {
        return lastTest;
    }

    public void setLastTest(Date lastTest) {
        this.lastTest = lastTest;
    }

}
