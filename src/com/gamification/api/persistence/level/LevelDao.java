package com.gamification.api.persistence.level;

import com.gamification.api.interfaces.persistence.level.ILevelDao;
import com.gamification.api.interfaces.persistence.level.Level;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

public class LevelDao  extends AdminPersistence<Level> implements ILevelDao {

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.level.Level";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Level> getEntityClass() {
		return (Class<Level>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Level";
	}
}
