package com.gamification.api.persistence.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gamification.api.interfaces.persistence.level.ILevelDao;
import com.gamification.api.interfaces.persistence.level.Level;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.AdminPersistenceFactory;
import com.gamification.api.persistence.config.ClassInstantiator;
import com.gamification.api.view.LevelView;

public class LevelDao  extends AdminPersistence<Level> implements ILevelDao {

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.level.Level";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Level> getEntityClass() {
		return (Class<Level>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Level";
	}
	
	
	/*public Collection<LevelView> getLevelsByGoal(final LevelView levelView)  {
		
		Collection<Level> levelEntityList = new ArrayList<Level>(); 
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try {
			final Query query = em.createQuery("select l from Level l where l.goalCode = 1? order by priority asc");
			query.setParameter(1, levelView.getGoalCode());
			levelEntityList = (Collection<Level>)query.getResultList();
		} finally {
			close(em);
		}
		return getTransformEntityObjToViewObj(levelEntityList);
	}
	


	private List<LevelView> getTransformEntityObjToViewObj(Collection<Level> levelEntityList) {
		
		List<LevelView> levelViewList = new ArrayList<LevelView> ();
		for(Level entity : levelEntityList) {
			LevelView view = new LevelView();
			view.setBadgeCode(entity.getBadge().getBadgeCode());
			view.setGoalCode(entity.getGoal().getGoalCode());
			view.setLevelCode(entity.getLevelCode());
			//view.setPoints(entity.getPoints().intValue());
			view.setRewardCode(entity.getReward().getRewardCode());
			view.setStory(entity.getStory());
			view.setImage(entity.getImage());
			view.setPriority(entity.getPriority());
			levelViewList.add(view);
		}
		return levelViewList;
	}*/
}
