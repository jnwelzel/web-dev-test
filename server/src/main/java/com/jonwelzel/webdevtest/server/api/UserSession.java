package com.jonwelzel.webdevtest.server.api;

/**
 * Created by jwelzel on 31/08/15.
 */
public class UserSession {

    private String id;
    private String address;
    private String agent;
    private String lastAccess;
    private String dateCreated;
    private String userId;

    public UserSession() {
    }

    public UserSession(String beanId, String address, String agent, String lastAccess, String userId) {
        this.id = beanId;
        this.address = address;
        this.agent = agent;
        this.lastAccess = lastAccess;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
