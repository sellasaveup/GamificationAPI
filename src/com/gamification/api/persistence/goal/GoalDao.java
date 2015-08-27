package com.gamification.api.persistence.goal;

import java.util.ArrayList;
import java.util.List;

import com.gamification.api.interfaces.persistence.goal.Goal;
import com.gamification.api.interfaces.persistence.goal.IGoalDao;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;
import com.gamification.api.view.GoalView;

public class GoalDao  extends AdminPersistence<Goal> implements IGoalDao{

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.goal.Goal";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Goal> getEntityClass() {
		return (Class<Goal>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Goal";
	}
	
	public  List<GoalView> getGoalViews() {
		List<GoalView> goalViews = new ArrayList<GoalView>();
		for(final Goal goal : retrieveAll()) {
			final GoalView goalView = new GoalView();
			goalView.setGoalId(goal.getGoalId());
			goalView.setGoalCode(goal.getGoalCode());
			goalView.setImage(goal.getImage());
			goalView.setName(goal.getName());
			goalView.setStory(goal.getStory());
			goalView.setExpiryDate(getFormattedDate(goal.getExpiryDate()));
			goalView.setDate(getFormattedDate(goal.getDate()));
			goalView.setStatus(goal.getStatus());
			goalView.setUserType(goal.getUserType());
			goalViews.add(goalView);
		}
		return goalViews;
	}
}
