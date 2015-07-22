package com.jonwelzel.webdevtest.server.persistence;

import com.google.inject.Singleton;
import com.jonwelzel.webdevtest.server.models.Skill;
import com.jonwelzel.webdevtest.server.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
@Singleton
public class InMemoryStore {

    List<User> users = new ArrayList<>();
    List<Skill> skills = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Skill> getSkills() {
        if(skills.isEmpty()) {
            String[] descriptions = {"HTML", "CSS", "Javascript", "Python", "Django", "Desenvolvimento iOS",
                    "Desenvolvimento Android"};
            for (int i = 0; i < descriptions.length; i++) {
                skills.add(new Skill(descriptions[i], 0));
            }
        }
        return skills;
    }
}
