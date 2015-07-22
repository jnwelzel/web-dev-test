package com.jonwelzel.webdevtest.server.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface BaseBean extends Serializable {

    Date getDateCreated();
    Date getDateUpdated();
    void setDateCreated(Date date);
    void setDateUpdated(Date date);

}
