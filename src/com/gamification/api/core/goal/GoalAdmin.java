package com.gamification.api.core.goal;

import com.gamification.api.interfaces.core.goal.IGoalAdmin;
import com.gamification.api.interfaces.persistence.goal.IGoalDao;

public class GoalAdmin implements IGoalAdmin {

	private IGoalDao goalDao;

	public void setGoalDao(final IGoalDao goalDao) {
		this.goalDao = goalDao;
	}
	
	
	
}
