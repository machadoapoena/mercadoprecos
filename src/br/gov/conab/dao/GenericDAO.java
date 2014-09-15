package br.gov.conab.dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.gov.conab.util.JPAUtil;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * AbstractDAO.java
 *
 * @date 10/09/2014
 * @author apoena.machado
 * @param <T>
 */
public class GenericDAO<T extends Serializable> {
	
	
	/** The entity manager. */
	@PersistenceContext(unitName = "appSwingCrudUnit")
    private final EntityManager entityManager;
    
    /** The persistent class. */
    private final Class<T> persistentClass;
	 
	@SuppressWarnings("unchecked")
	public GenericDAO() {

		this.entityManager = JPAUtil.getEntityManager();
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Gets the entity manager.
	 *
	 * @return the entity manager
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	 
	/**
	 * Save.
	 *
	 * @param entity the entity
	 */
	protected void save(T entity) {

		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().persist(entity);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			close();
		}
	}
	 
	/**
	 * Update.
	 *
	 * @param entity the entity
	 */
	protected void update(T entity) {

		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().merge(entity);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			close();
		}
	}
	 
	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	protected void delete(T entity) {

		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().remove(entity);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			close();
		}
	}
	 
	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws Exception {

		Session session = (Session) getEntityManager().getDelegate();
		return session.createCriteria(this.persistentClass).list();
	}
	 
	/**
	 * Find by name.
	 *
	 * @param nome the nome
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public T findByName(String nome) {

		Session session = (Session) getEntityManager().getDelegate();
		return (T) session.createCriteria(this.persistentClass).add(Restrictions.eq("nome", nome).ignoreCase()).uniqueResult();
	}
	 
    /**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public T findById(long id) {

		Session session = (Session) getEntityManager().getDelegate();
		return (T) session.createCriteria(this.persistentClass).add(Restrictions.eq("id", id)).uniqueResult();
	}
	 
	/**
	 * Close.
	 */
	private void close() {

		if (getEntityManager().isOpen()) {
			getEntityManager().close();
		}
		shutdown();
	}
	 
    /**
     * Shutdown.
     */
	private void shutdown() {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("SHUTDOWN").executeUpdate();
		em.close();
	}
}