package com.gamification.api.persistence.badge;

import com.gamification.api.interfaces.persistence.badge.Badge;
import com.gamification.api.interfaces.persistence.badge.IBadgeDao;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

public class BadgeDao extends AdminPersistence<Badge> implements IBadgeDao {

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.badge.Badge";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Badge> getEntityClass() {
		return (Class<Badge>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Badge";
	}
}
