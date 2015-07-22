package com.jonwelzel.webdevtest.server.persistence.daos;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.di.interceptors.OnSave;
import com.jonwelzel.webdevtest.server.models.User;
import com.jonwelzel.webdevtest.server.persistence.InMemoryStore;

import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class UserDaoMockImpl implements UserDaoInterface {

    private InMemoryStore store;

    @Inject
    public UserDaoMockImpl(InMemoryStore store) {
        this.store = store;
    }

    @Override
    public List<User> findAll() {
        return store.getUsers();
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    @OnSave
    public User save(User obj) {
        System.out.println("UserDaoMockImpl.save");
        return null;
    }

    @Override
    public User update(User obj) {
        return null;
    }

    @Override
    public User delete(User obj) {
        return null;
    }

}
