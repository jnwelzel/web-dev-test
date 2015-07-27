package com.jonwelzel.webdevtest.server.jdbi;

import java.util.Date;

/**
 * Created by jwelzel on 22/07/15.
 */
public abstract class AbstractBaseBean implements BaseBean {

    Date dateCreated;
    Date dateUpdated;

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
}
