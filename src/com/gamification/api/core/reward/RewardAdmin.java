package com.gamification.api.core.reward;

import com.gamification.api.interfaces.core.reward.IRewardAdmin;
import com.gamification.api.interfaces.persistence.reward.IRewardDao;

public class RewardAdmin implements IRewardAdmin {

	
	private IRewardDao rewardDao;

	public void setRewardDao(final IRewardDao rewardDao) {
		this.rewardDao = rewardDao;
	}
	
}
