package com.gamification.api.persistence.goal;

import com.gamification.api.interfaces.persistence.goal.Goal;
import com.gamification.api.interfaces.persistence.goal.IGoalDao;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

public class GoalDao  extends AdminPersistence<Goal> implements IGoalDao{

	private static final String ENTITY_PATH = "com.gamification.api.persistence.admin.goal.Goal";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Goal> getEntityClass() {
		return (Class<Goal>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Goal";
	}
}
