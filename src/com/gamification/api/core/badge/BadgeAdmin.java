package com.gamification.api.core.badge;

import com.gamification.api.interfaces.core.badge.IBadgeAdmin;
import com.gamification.api.interfaces.persistence.badge.IBadgeDao;

public class BadgeAdmin implements IBadgeAdmin {
	
	private IBadgeDao badgeDao;

	public void setBadgeDao(final IBadgeDao badgeDao) {
		this.badgeDao = badgeDao;
	}
	
}
