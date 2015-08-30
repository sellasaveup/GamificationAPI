package com.gamification.api.persistence.user;

import java.util.ArrayList;
import java.util.List;

import com.gamification.api.interfaces.persistence.user.IUserDao;
import com.gamification.api.interfaces.persistence.user.User;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

public class UserDao extends AdminPersistence<User> implements IUserDao { 

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.user.User";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<User> getEntityClass() {
		return (Class<User>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from User";
	}
	
	
	public  List<com.gamification.api.view.User> getUserViews() {
		List<com.gamification.api.view.User> userViews = new ArrayList<com.gamification.api.view.User>();
		for(final User user : retrieveAll()) {
			final com.gamification.api.view.User userView = new com.gamification.api.view.User();
			userView.setUserId(user.getUserId());
			userView.setUserCode(user.getUserCode());
			userView.setImage(user.getImage());
			userView.setName(user.getName());
			userView.setNickName(user.getNickName());
			userView.setDate(getFormattedDate(user.getDate()));
			userView.setStatus(user.getStatus());
			userView.setUserType(user.getUserType());
			userViews.add(userView);
		}
		return userViews;
	}
}
