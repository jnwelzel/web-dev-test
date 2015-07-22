package com.jonwelzel.webdevtest.server.models;

import com.jonwelzel.webdevtest.server.persistence.BaseBean;

import java.util.List;

/**
 * Created by jwelzel on 21/07/15.
 */
public class User implements BaseBean {

    private String name;
    private String email;
    private List<Skill> skills;

}
