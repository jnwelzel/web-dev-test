package com.jonwelzel.webdevtest.server.jdbi;

import com.google.inject.Singleton;
import com.jonwelzel.webdevtest.server.api.AccountType;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.Skill;
import com.jonwelzel.webdevtest.server.api.SkillGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
@Singleton
public class InMemoryStore {

    List<Candidate> candidates = new ArrayList<>();
    List<Skill> skillsList = new ArrayList<>();

    public InMemoryStore() {
        candidates.add(buildAdmin());
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public List<Skill> getSkillsList() {
        if(skillsList.isEmpty()) {
            skillsList.add(new Skill("HTML", 0, SkillGroup.FRONTEND));
            skillsList.add(new Skill("CSS", 0, SkillGroup.FRONTEND));
            skillsList.add(new Skill("Javascript", 0, SkillGroup.FRONTEND));

            skillsList.add(new Skill("Python", 0, SkillGroup.BACKEND));
            skillsList.add(new Skill("Django", 0, SkillGroup.BACKEND));

            skillsList.add(new Skill("Desenvolvimento iOS", 0, SkillGroup.MOBILE));
            skillsList.add(new Skill("Desenvolvimento Android", 0, SkillGroup.MOBILE));
        }
        return skillsList;
    }

    private Candidate buildAdmin() {
        Candidate admin = new Candidate();
        admin.setName("Admin");
        admin.setEmail("admin@admin.com");
        admin.setPasswordHash("1000:ea270d69e9f07766c2d22a45fb49cbfb08980cd6c9f51604:e8fd91bd20c4a316383828d14aa7645716435396f6b38480");
        admin.setAccountType(AccountType.ADMIN);
        admin.setId("934d49079d7bdc24c770dfc88b8a4e1f866bbcd1139523dc");
        admin.setDateCreated(new Date());
        admin.setDateUpdated(new Date());
        admin.setSkills(buildSkills());
        return admin;
    }

    private List<Skill> buildSkills() {
        List<Skill> skills = new ArrayList<>();
        skills = buildSkillsByGroup(skills, SkillGroup.FRONTEND, new String[]{"CSS", "HTML", "Javascript"});
        skills = buildSkillsByGroup(skills, SkillGroup.BACKEND, new String[]{"Python", "Django"});
        skills = buildSkillsByGroup(skills, SkillGroup.MOBILE, new String[]{"Desenvolvimento iOS", "Desenvolvimento Android"});
        return skills;
    }

    private List<Skill> buildSkillsByGroup(List<Skill> skills, SkillGroup group, String[] descriptions) {
        for (int i = 0; i < descriptions.length; i++) {
            Skill skill = new Skill();
            skill.setScore(10);
            skill.setDescription(descriptions[i]);
            skill.setSkillGroup(group);
            skill.setDateCreated(new Date());
            skill.setDateUpdated(new Date());
            skills.add(skill);
        }
        return skills;
    }

}
