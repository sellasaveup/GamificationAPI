package com.gamification.api.persistence.user;

import com.gamification.api.interfaces.persistence.user.IUserChannelDao;
import com.gamification.api.interfaces.persistence.user.UserChannel;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

public class UserChannelDao extends AdminPersistence<UserChannel> implements IUserChannelDao {

	private static final String ENTITY_PATH = "com.gamification.api.persistence.admin.user.UserChannel";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<UserChannel> getEntityClass() {
		return (Class<UserChannel>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from UserChannel";
	}
}
