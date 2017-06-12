package com.us.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author TatvaSoft
 *
 */
@Repository
public abstract class TatvaSoftDAOImpl<T,ID extends Serializable> implements ITatvaSoftDAO<T, ID> {

	private Logger logger = LoggerFactory.getLogger(TatvaSoftDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Class<T> entityType;
	   
    @Autowired
    public TatvaSoftDAOImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    public Class<T> getPersistentClass() {
        return entityType;
    }
    
	@Transactional
	public void save(T entity) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			logger.error("Error while saving the entity : {}", e.getMessage());
		} finally {
			session.close();
		}
	}

	@Transactional
	public void persist(T entity) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(entity);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			logger.error("Error while persisting the entity : {}", e.getMessage());
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public T find(ID id) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			 return  (T) session.get(entityType, id);
		}finally{
			 transaction.commit();
			 session.close();
		}
       
    }
    
   
    @Transactional(readOnly = true)
    public List<T> findAll() {
    	Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<T> entities = findByCriteriaSortByUpdatedDate(session);
			 return entities;
		} finally {
			 transaction.commit();
			session.close();
		}
    }
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteriaSortByUpdatedDate(Session session, Criterion... criterion) {
        Criteria crit = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
   }

	@Transactional
    public void delete(ID id) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(session.get(getPersistentClass(), id));
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			logger.error("Error while deleting the entity - id : {} - error : {}", id, e.getMessage());
		} finally {
			session.close();
		}
    }
}
