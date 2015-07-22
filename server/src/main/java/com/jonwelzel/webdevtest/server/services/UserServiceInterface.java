package com.jonwelzel.webdevtest.server.services;

import com.jonwelzel.webdevtest.server.models.User;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface UserServiceInterface {

    User saveUser(User user);
    User getUserByEmail(String email);

}
