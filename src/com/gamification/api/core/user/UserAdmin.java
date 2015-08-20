package com.gamification.api.core.user;

import com.gamification.api.interfaces.core.user.IUserAdmin;
import com.gamification.api.interfaces.persistence.user.IUserDao;

public class UserAdmin implements IUserAdmin {
	
	private IUserDao userDao;

	public void setUserDao(final IUserDao userDao) {
		this.userDao = userDao;
	}
}
