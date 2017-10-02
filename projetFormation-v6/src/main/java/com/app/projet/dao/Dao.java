package com.app.projet.dao;

import com.app.projet.exceptions.OrgUndeletableException;
import com.app.projet.exceptions.StockNegatifException;

import java.util.List;

public interface Dao<T,S> {

    T create(T t);

    T update(T t)throws StockNegatifException;

    T find(S s);

    List<T> findAll();

    boolean delete(T t ) throws OrgUndeletableException;
}
