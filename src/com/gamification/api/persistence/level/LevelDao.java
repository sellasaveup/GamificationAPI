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
	
	
	public Collection<LevelView> getLevelsByGoal(final LevelView levelView)  {
		
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
			final LevelView view = new LevelView();
			view.setLevelId(entity.getLevelId());
			view.setBadgeCode(entity.getBadgeCode());
			view.setGoalCode(entity.getGoalCode());
			view.setLevelCode(entity.getLevelCode());
			view.setRewardCode(entity.getRewardCode());
			view.setStory(entity.getStory());
			view.setImage(entity.getImage());
			view.setPriority(entity.getPriority());
			view.setStartPoint(entity.getStartPoint().intValue());
			view.setEndPoint(entity.getEndPoint().intValue());
			view.setDate(getFormattedDate(entity.getDate()));
			levelViewList.add(view);
		}
		return levelViewList;
	}
	
	public List<Level> getLevelByGoalCode(final String goalCode) {
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createQuery("from Level l where l.goalCode = ?1");
			query.setParameter(1, goalCode);
			return query.getResultList();
		} finally {
			close(em);
		}
	}
}
