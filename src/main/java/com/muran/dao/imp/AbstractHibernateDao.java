package com.muran.dao.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.common.base.Preconditions;
import com.muran.dao.operation.IOperations;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements
		IOperations<T> {

	protected Logger log ;

	public AbstractHibernateDao() {
		log = Logger.getLogger(this.getClass());
	}

	protected Class<T> clazz;

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	protected final void setClazz(final Class<T> clazzToSet) {
		this.clazz = Preconditions.checkNotNull(clazzToSet);
	}

	public final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public final Session newSession() {
		return sessionFactory.openSession();
	}
	@Override
	public T findOne(final Serializable id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.list();
	}

	@Override
	public void saveOrUpdate(final T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void persist(final T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().persist(entity);
	}


	@Override
	public void save(final T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().save(entity);
	}

	@Override
	public T merge(T entity) {
		Preconditions.checkNotNull(entity);
		return (T) getCurrentSession().merge(entity);
	}

	@Override
	public T update(final T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().update(entity);
		return entity;
		// return (T)getCurrentSession().merge(entity);
	}

	@Override
	public void delete(final T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().delete(entity);
	}

	@Override
	public void deleteById(final long entityId) {
		final T entity = findOne(entityId);
		Preconditions.checkState(entity != null);
		delete(entity);
	}

}