package com.gamification.api.persistence.challenge;

import com.gamification.api.interfaces.persistence.challenge.Challenge;
import com.gamification.api.interfaces.persistence.challenge.IChallengeDao;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.ClassInstantiator;

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
	
	/*public Collection<ChallengeView> getChallengesByGoal(final ChallengeView challengeView)  {
		
		Collection<Challenge> challengeEntityList = new ArrayList<Challenge>(); 
		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		List<Object>	list =	new ArrayList<Object>();
		try {
			//final Query query = em.createQuery("select c from Challenge c where c.goal.goalCode = ?1");
			//query.setParameter(1, challengeView.getGoalCode());
			final Query query = em.createNativeQuery("select * from SS_MA_CHALLENGE c where c.GOAL_CODE = ?1 order by expiry_Date desc ", Challenge.class);
			query.setParameter(1, challengeView.getGoalCode());
			//challengeEntityList = 
			List<Challenge> list1 =	query.getResultList();
			List<ChallengeView> challengeViewList = new ArrayList<ChallengeView> ();
			for(Object entity1 : list1) {
				
				if(entity1 instanceof Challenge) {
				Challenge entity2 = (Challenge)entity1;
				System.out.println("--------"+entity1);
				}
			}
		} finally {
			close(em);
		}
		return getTransformEntityObjToViewObj(list);
	}
	
	private List<ChallengeView> getTransformEntityObjToViewObj(List<Object> challengeEntity) {
		
		List<ChallengeView> challengeViewList = new ArrayList<ChallengeView> ();
		for(Object entity1 : challengeEntity) {
			Challenge entity = (Challenge)entity1;
			System.out.println("-------"+entity);
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
	}*/
	
	
}