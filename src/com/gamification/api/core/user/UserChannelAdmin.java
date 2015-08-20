package com.gamification.api.core.user;

import com.gamification.api.interfaces.core.user.IUserChannelAdmin;
import com.gamification.api.interfaces.persistence.user.IUserChannelDao;

public class UserChannelAdmin implements IUserChannelAdmin {

	private IUserChannelDao userChannelDao;

	public void setUserChannelDao(final IUserChannelDao userChannelDao) {
		this.userChannelDao = userChannelDao;
	}
	
}
