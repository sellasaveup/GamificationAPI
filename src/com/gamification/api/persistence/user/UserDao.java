package com.gamification.api.persistence.user;

import com.gamification.api.interfaces.persistence.user.IUserDao;
import com.gamification.api.interfaces.persistence.user.User;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

public class UserDao extends AdminPersistence<User> implements IUserDao { 

	private static final String ENTITY_PATH = "com.gamification.api.persistence.admin.user.User";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<User> getEntityClass() {
		return (Class<User>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from User";
	}
}
