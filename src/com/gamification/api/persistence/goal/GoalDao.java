package com.gamification.api.persistence.goal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gamification.api.interfaces.persistence.goal.Goal;
import com.gamification.api.interfaces.persistence.goal.IGoalDao;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.AdminPersistenceFactory;
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
	
	public Map<String, Object> getGoalTrackingReport() {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Map<String, Object> result = new HashMap<String,Object>();
			final Query query = em.createNativeQuery("select distinct goal_code as goal, COUNT(goal_code) as count from ss_tr_user_action group by goal_code");
			final List<Object[]> list = query.getResultList();
			final List<String> xAxis = new ArrayList<String>();
			final List<String> yAxis = new ArrayList<String>();
			for(Object[] object : list) {
				xAxis.add(String.valueOf(object[0]));
				yAxis.add(String.valueOf(object[1]));
			}
			result.put("xAxis", xAxis);
			result.put("yAxis", yAxis);
			return result;
		} finally {
			close(em);
		}
	}
}
