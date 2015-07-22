package com.jonwelzel.webdevtest.server.persistence.daos;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.di.interceptors.OnSave;
import com.jonwelzel.webdevtest.server.di.interceptors.OnUpdate;
import com.jonwelzel.webdevtest.server.models.Candidate;
import com.jonwelzel.webdevtest.server.persistence.InMemoryStore;

import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class CandidateDaoMockImpl implements CandidateDaoInterface {

    private InMemoryStore store;

    @Inject
    public CandidateDaoMockImpl(InMemoryStore store) {
        this.store = store;
    }

    @Override
    public List<Candidate> findAll() {
        return store.getCandidates();
    }

    @Override
    public Candidate findById(String id) {
        return null;
    }

    @Override
    @OnSave
    public Candidate save(Candidate obj) {
        store.addCandidate(obj);
        return obj;
    }

    @Override
    @OnUpdate
    public Candidate update(Candidate obj) {
        return null;
    }

    @Override
    public Candidate delete(Candidate obj) {
        return null;
    }

}
