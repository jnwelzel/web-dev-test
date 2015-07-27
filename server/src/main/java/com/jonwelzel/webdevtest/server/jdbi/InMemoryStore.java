package com.jonwelzel.webdevtest.server.jdbi;

import com.google.inject.Singleton;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.Skill;
import com.jonwelzel.webdevtest.server.api.SkillGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
@Singleton
public class InMemoryStore {

    List<Candidate> candidates = new ArrayList<>();
    List<Skill> skillsList = new ArrayList<>();

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

}
