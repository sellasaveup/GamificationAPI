package com.gamification.api.persistence;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gamification.api.interfaces.persistence.IPersistence;
import com.gamification.api.persistence.config.AdminPersistenceFactory;

public abstract class AdminPersistence<ENTITY>  implements IPersistence<ENTITY>{

	public void create(ENTITY entity) {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager(); 
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} finally {
			close(em);
		}
	}

	public void update(final ENTITY entity) {
		
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} finally {
			close(em);
		}
	}

	public void delete(final Serializable id) {
		
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try {
			ENTITY entity = em.find(getEntityClass(), id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} finally {
			close(em);
		}
	}

	public ENTITY retrieve(final Serializable id) {
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try {
			return em.find(getEntityClass(), id);
		} finally {
			close(em);
		}
	}

	@SuppressWarnings("unchecked")
	public List<ENTITY> retrieveAll() {
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try {
			final Query query = em.createQuery(getRetrieveAllEntitiesQuery(), getEntityClass());
			return query.getResultList();
		} finally {
			close(em);
		}
	}

	protected abstract Class<ENTITY> getEntityClass();
	protected abstract String getRetrieveAllEntitiesQuery();
	
	protected void close(final EntityManager entityManager) {
		AdminPersistenceFactory.close(entityManager);
	}
	
	protected String getFormattedDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
}
