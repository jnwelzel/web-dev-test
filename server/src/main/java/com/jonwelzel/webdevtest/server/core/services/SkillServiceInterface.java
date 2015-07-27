package com.jonwelzel.webdevtest.server.core.services;

import com.jonwelzel.webdevtest.server.api.Skill;

import java.util.List;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface SkillServiceInterface {

    List<Skill> getAllSkills();

}
