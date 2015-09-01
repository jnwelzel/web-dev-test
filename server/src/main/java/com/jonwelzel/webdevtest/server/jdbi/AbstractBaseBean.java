package com.jonwelzel.webdevtest.server.jdbi;

import com.jonwelzel.webdevtest.server.api.BaseBean;

import java.util.Date;

/**
 * Created by jwelzel on 22/07/15.
 */
public abstract class AbstractBaseBean implements BaseBean {

    protected Date dateCreated;
    protected Date dateUpdated;
    protected String id;

    @Override
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public Date getDateUpdated() {
        return dateUpdated;
    }

    @Override
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
