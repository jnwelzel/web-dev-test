package com.jonwelzel.webdevtest.server.jdbi.daos;

import com.jonwelzel.webdevtest.server.api.BaseBean;

import java.util.List;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface BaseDao<T extends BaseBean> {

    List<T> findAll();

    T findById(String id);

    T save(T obj);

    T update(T obj);

    T delete(T obj);

}
