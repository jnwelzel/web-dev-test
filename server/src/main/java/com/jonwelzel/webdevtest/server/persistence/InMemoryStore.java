package com.jonwelzel.webdevtest.server.persistence;

import com.google.inject.Singleton;
import com.jonwelzel.webdevtest.server.models.Candidate;
import com.jonwelzel.webdevtest.server.models.Skill;

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
            String[] descriptions = {"HTML", "CSS", "Javascript", "Python", "Django", "Desenvolvimento iOS",
                    "Desenvolvimento Android"};
            for (int i = 0; i < descriptions.length; i++) {
                skillsList.add(new Skill(descriptions[i], 0));
            }
        }
        return skillsList;
    }

}
