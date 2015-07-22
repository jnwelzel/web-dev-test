package com.jonwelzel.webdevtest.server.persistence.daos;

import com.jonwelzel.webdevtest.server.di.interceptors.OnSave;
import com.jonwelzel.webdevtest.server.di.interceptors.OnUpdate;
import com.jonwelzel.webdevtest.server.persistence.BaseBean;

import java.util.List;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface BaseDao<T extends BaseBean> {

    List<T> findAll();

    T findById(String id);


    T save(T obj);

    @OnUpdate
    T update(T obj);

    T delete(T obj);

}
