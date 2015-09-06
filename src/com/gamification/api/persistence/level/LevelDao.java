package com.gamification.api.persistence.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			view.setName(entity.getName());
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

	public List<LevelView> getLevelByGoalCode(final String goalCode) {
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createQuery("from Level l where l.goalCode = ?1");
			query.setParameter(1, goalCode);
			return getTransformEntityObjToViewObj(query.getResultList());
		} finally {
			close(em);
		}
	}


	public List<String> getLevelsReportForUser(final String userCode, final String goalCode) {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createNativeQuery("SELECT  COALESCE(COUNT(ul.LEVEL_CODE), 0) AS month FROM ( SELECT 1 AS Month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 ) m LEFT JOIN ss_tr_user_level ul ON month(ul.DATE) = m.Month and ul.USER_CODE=?1 and ul.GOAL_CODE =?2 GROUP BY m.Month ORDER BY m.Month");
			query.setParameter(1, userCode);
			query.setParameter(2, goalCode);
			return query.getResultList();
		} finally {
			close(em);
		}
	}

	public List<String> getLevelJourneyReport(final String goalCode) {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createNativeQuery("SELECT  COALESCE(COUNT(ul.LEVEL_CODE), 0) AS month FROM ( SELECT 1 AS Month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 ) m LEFT JOIN ss_tr_user_level ul ON month(ul.DATE) = m.Month and ul.GOAL_CODE =?1 GROUP BY m.Month ORDER BY m.Month");
			query.setParameter(1, goalCode);
			return query.getResultList();
		} finally {
			close(em);
		}
	}

	public Map<String, Object> getLevelTrackingReport() {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Map<String, Object> result = new HashMap<String,Object>();
			final Query query = em.createNativeQuery("select distinct level_code as level, COUNT(level_code) as count from ss_tr_user_level group by level_code");
			final List<Object[]> list =query.getResultList();
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
