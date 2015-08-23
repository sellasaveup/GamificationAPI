package com.gamification.api.persistence.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gamification.api.interfaces.persistence.challenge.Challenge;
import com.gamification.api.interfaces.persistence.challenge.IChallengeDao;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.AdminPersistenceFactory;
import com.gamification.api.persistence.config.ClassInstantiator;
import com.gamification.api.view.ChallengeView;

public class ChallengeDao extends AdminPersistence<Challenge> implements IChallengeDao {

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.challenge.Challenge";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Challenge> getEntityClass() {
		return (Class<Challenge>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Challenge";
	}
	
	public Collection<ChallengeView> getChallengesByGoal(final ChallengeView challengeView)  {
		
		Collection<Challenge> challengeEntityList = new ArrayList<Challenge>(); 
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try {
			//final Query query = em.createQuery("select c from Challenge c where c.goal.goalCode = ?1");
			//query.setParameter(1, challengeView.getGoalCode());
			final Query query = em.createNativeQuery("select * from SS_MA_CHALLENGE c where c.GOAL_CODE = ?1 and order by expiryDate desc ");
			query.setParameter(1, challengeView.getGoalCode());
			challengeEntityList = (Collection<Challenge>)query.getResultList();
		} finally {
			close(em);
		}
		return getTransformEntityObjToViewObj(challengeEntityList);
	}
	
	private List<ChallengeView> getTransformEntityObjToViewObj(Collection<Challenge> challengeEntity) {
		
		List<ChallengeView> challengeViewList = new ArrayList<ChallengeView> ();
		for(Challenge entity : challengeEntity) {
			ChallengeView view = new ChallengeView();
			view.setActionCode(entity.getActionCode());
			view.setBadgeCode(entity.getBadge().getBadgeCode());
			view.setExpiryDate(entity.getExpiryDate().toString());
			view.setGoalCode(entity.getGoal().getGoalCode());
			view.setImage(entity.getImage());
			view.setOccurrence(entity.getOccurance().intValue());
			view.setPoints(entity.getPoints().intValue());
			view.setRewardCode(entity.getReward().getRewardCode());
			view.setStory(entity.getStory());
			challengeViewList.add(view);
		}
		return challengeViewList;
	}
	
	
}