package com.jonwelzel.webdevtest.server.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class Candidate implements BaseBean {

    private static final Integer MINIMUM_SCORE = 7;

    @JsonProperty
    @Size(min = 3)
    @NotEmpty
    private String name;

    @JsonProperty
    @Email
    @NotEmpty
    private String email;

    @JsonProperty
    @NotEmpty
    @Size(min = 7, max = 7)
    private List<Skill> skills;

    @JsonProperty
    private Date dateCreated;

    @JsonProperty
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

    public List<Skill> getSkillsByGroup(SkillGroup group) {
        List<Skill> result = new ArrayList<>();
        for(Skill skill : skills) {
            if(skill.getSkillGroup().equals(group)) {
                result.add(skill);
            }
        }
        return result;
    }

    @JsonProperty
    public boolean isFrontend() {
        return calculateGroupScore(getSkillsByGroup(SkillGroup.FRONTEND)) == 3;
    }

    @JsonProperty
    public boolean isBackend() {
        return calculateGroupScore(getSkillsByGroup(SkillGroup.FRONTEND)) == 2;
    }

    @JsonProperty
    public boolean isMobile() {
        return calculateGroupScore(getSkillsByGroup(SkillGroup.FRONTEND)) >= 1;
    }

    private Integer calculateGroupScore(List<Skill> skills) {
        Integer result = 0;
        for(Skill skill : skills) {
            if(skill.getScore() >= MINIMUM_SCORE) {
                result++;
            }
        }
        return result;
    }
}
