package com.jonwelzel.webdevtest.server.services;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.models.User;
import com.jonwelzel.webdevtest.server.persistence.daos.UserDaoInterface;

/**
 * Created by jwelzel on 22/07/15.
 */
public class UserServiceImpl implements UserServiceInterface {

    private final UserDaoInterface userDao;

    @Inject
    public UserServiceImpl(@MockDao UserDaoInterface userDao) {
        this.userDao = userDao;
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

}
