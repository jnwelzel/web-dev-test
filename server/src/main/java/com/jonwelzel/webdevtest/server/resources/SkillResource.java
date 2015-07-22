package com.jonwelzel.webdevtest.server.resources;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.models.Skill;
import com.jonwelzel.webdevtest.server.services.SkillServiceInterface;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
@Path("skills")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SkillResource {

    private final SkillServiceInterface service;

    @Inject
    public SkillResource(SkillServiceInterface service) {
        this.service = service;
    }

    @GET
    public List<Skill> list() {
        return service.getAllSkills();
    }

}
