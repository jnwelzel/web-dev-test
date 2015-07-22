package com.jonwelzel.webdevtest.server.models;

import com.jonwelzel.webdevtest.server.persistence.BaseBean;

import java.util.Date;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class Candidate implements BaseBean {

    private String name;
    private String email;
    private List<Skill> skills;
    private Date dateCreated;
    private Date dateUpdated;

    public Candidate() {
    }

    public Candidate(String name, String email, Date dateCreated, Date dateUpdated, List<Skill> skills) {
        this.name = name;
        this.email = email;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.skills = skills;
    }

    @Override
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public Date getDateUpdated() {
        return dateUpdated;
    }

    @Override
    public void setDateCreated(Date date) {
        dateCreated = date;
    }

    @Override
    public void setDateUpdated(Date date) {
        dateUpdated = date;
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
}
