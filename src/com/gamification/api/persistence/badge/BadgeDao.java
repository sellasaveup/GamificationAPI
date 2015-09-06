package com.gamification.api.persistence.badge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gamification.api.interfaces.persistence.badge.Badge;
import com.gamification.api.interfaces.persistence.badge.IBadgeDao;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.AdminPersistenceFactory;
import com.gamification.api.persistence.config.ClassInstantiator;
import com.gamification.api.view.BadgeView;

public class BadgeDao extends AdminPersistence<Badge> implements IBadgeDao {

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.badge.Badge";

	@SuppressWarnings("unchecked")
	@Override
	protected Class<Badge> getEntityClass() {
		return (Class<Badge>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Badge";
	}

	private List<BadgeView> transformEntityToView(List<Badge> badges) {
		List<BadgeView> badgeViews = new ArrayList<BadgeView>();
		for(final Badge badge : badges) {
			final BadgeView badgeView = new BadgeView();
			badgeView.setBadgeId(badge.getBadgeId());
			badgeView.setBadgeCode(badge.getBadgeCode());
			badgeView.setGoalCode(badge.getGoalCode());
			badgeView.setImage(badge.getImage());
			badgeView.setName(badge.getName());
			badgeView.setStory(badge.getStory());
			badgeView.setExpiryDate(getFormattedDate(badge.getExpiryDate()));
			badgeView.setDate(getFormattedDate(badge.getDate()));
			badgeViews.add(badgeView);
		}
		return badgeViews;
	}


	public List<BadgeView> getBadgeByGoalCode(final String goalCode) {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createQuery("from Badge b where b.goalCode = ?1");
			query.setParameter(1, goalCode);
			return transformEntityToView(query.getResultList());
		} finally {
			close(em);
		}
	}

	public List<String> getBadgesReportForUser(final String userCode, final String goalCode) {

		//SELECT count(BADGE_CODE) as badges FROM ss_tr_user_badge where USER_CODE=?1 and GOAL_CODE =?2 group by month(DATE) order by month(DATE)
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createNativeQuery("SELECT COALESCE(COUNT(ub.BADGE_CODE), 0) AS month FROM ( SELECT 1 AS Month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 ) m LEFT JOIN ss_tr_user_badge ub ON month(ub.DATE) = m.Month and ub.USER_CODE=?1 and ub.GOAL_CODE =?2 GROUP BY m.Month ORDER BY m.Month");
			query.setParameter(1, userCode);
			query.setParameter(2, goalCode);
			return query.getResultList();
		} finally {
			close(em);
		}
	}

	public List<String> getBadgeJourneyReport(final String goalCode) {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createNativeQuery("SELECT COALESCE(COUNT(ub.BADGE_CODE), 0) AS month FROM ( SELECT 1 AS Month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 ) m LEFT JOIN ss_tr_user_badge ub ON month(ub.DATE) = m.Month and ub.GOAL_CODE =?1 GROUP BY m.Month ORDER BY m.Month");
			query.setParameter(1, goalCode);
			return query.getResultList();
		} finally {
			close(em);
		}
	}

	public Map<String, Object> getBadgeTrackingReport() {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Map<String, Object> result = new HashMap<String,Object>();
			final Query query = em.createNativeQuery("select distinct badge_code as badge, COUNT(badge_code) as count from ss_tr_user_badge group by badge_code");
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
