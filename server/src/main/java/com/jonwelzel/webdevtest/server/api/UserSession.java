package com.jonwelzel.webdevtest.server.api;

import com.jonwelzel.webdevtest.server.jdbi.AbstractBaseBean;

import java.util.Date;

/**
 * Created by jwelzel on 31/08/15.
 */
public class UserSession extends AbstractBaseBean {

    private String address;
    private String agent;
    private Date lastAccess;
    private String userId;

    public UserSession() {
    }

    public UserSession(String beanId, String address, String agent, Date lastAccess, String userId) {
        this.id = beanId;
        this.address = address;
        this.agent = agent;
        this.lastAccess = lastAccess;
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
