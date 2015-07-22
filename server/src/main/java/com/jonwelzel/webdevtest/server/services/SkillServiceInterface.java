package com.jonwelzel.webdevtest.server.services;

import com.jonwelzel.webdevtest.server.models.Skill;

import java.util.List;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface SkillServiceInterface {

    List<Skill> getAllSkills();

}
