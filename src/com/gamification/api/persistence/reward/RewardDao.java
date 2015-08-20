package com.gamification.api.persistence.reward;

import com.gamification.api.interfaces.persistence.reward.IRewardDao;
import com.gamification.api.interfaces.persistence.reward.Reward;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

public class RewardDao  extends AdminPersistence<Reward> implements IRewardDao {

	private static final String ENTITY_PATH = "com.gamification.api.persistence.admin.reward.Reward";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Reward> getEntityClass() {
		return (Class<Reward>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Reward";
	}

}
