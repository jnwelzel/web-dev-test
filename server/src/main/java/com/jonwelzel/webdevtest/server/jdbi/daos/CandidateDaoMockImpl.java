package com.jonwelzel.webdevtest.server.jdbi.daos;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.core.di.interceptors.OnSave;
import com.jonwelzel.webdevtest.server.core.di.interceptors.OnUpdate;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.jdbi.InMemoryStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class CandidateDaoMockImpl implements CandidateDaoInterface {

    private InMemoryStore store;
    private static final Logger log = LoggerFactory.getLogger(CandidateDaoMockImpl.class.getName());

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
        log.info("Salvando candidato \"" + obj.getName() + "\"...");
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
