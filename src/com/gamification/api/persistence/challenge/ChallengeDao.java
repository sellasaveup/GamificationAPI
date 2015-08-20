package com.gamification.api.persistence.challenge;

import com.gamification.api.interfaces.persistence.challenge.Challenge;
import com.gamification.api.interfaces.persistence.challenge.IChallengeDao;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

public class ChallengeDao extends AdminPersistence<Challenge> implements IChallengeDao {

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.challenge.Challenge";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Challenge> getEntityClass() {
		return (Class<Challenge>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Challenge";
	}
}