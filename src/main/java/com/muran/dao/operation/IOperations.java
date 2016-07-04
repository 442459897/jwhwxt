package com.muran.dao.operation;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;


public interface IOperations<T extends Serializable> {
     
        T findOne(final Serializable id);

        List<T> findAll();

        void persist(final T entity);

        void save(final T entity);

        void saveOrUpdate(final T entity);

        T update(final T entity);

        void delete(final T entity);

        void deleteById(final long entityId);

		T merge(final T entity);

        Session getCurrentSession();

        Session newSession();
}