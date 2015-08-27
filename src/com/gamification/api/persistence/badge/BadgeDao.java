package com.gamification.api.persistence.badge;

import java.util.ArrayList;
import java.util.List;

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
}
