package com.gamification.api.persistence.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class AdminPersistenceFactory {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("GamificationFramework");
	
	public static EntityManager getPersistenceManager() {
		return  FACTORY.createEntityManager();
	}
	
	public static void close(final EntityManager entityManager) {
		
		if(entityManager!=null) {
			entityManager.clear();
			entityManager.close();
		}
	}
}
