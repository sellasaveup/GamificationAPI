package com.gamification.api.persistence.reward;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gamification.api.interfaces.persistence.reward.IRewardDao;
import com.gamification.api.interfaces.persistence.reward.Reward;
import com.gamification.api.persistence.AdminPersistence;
import com.gamification.api.persistence.config.AdminPersistenceFactory;
import com.gamification.api.persistence.config.ClassInstantiator;
import com.gamification.api.view.RewardView;

public class RewardDao  extends AdminPersistence<Reward> implements IRewardDao {

	private static final String ENTITY_PATH = "com.gamification.api.interfaces.persistence.reward.Reward";
	
	@SuppressWarnings("unchecked")
	@Override
	protected Class<Reward> getEntityClass() {
		return (Class<Reward>) ClassInstantiator.loadClass(ENTITY_PATH);
	}

	@Override
	protected String getRetrieveAllEntitiesQuery() {
		return "from Reward";
	}

	public List<RewardView> getRewardByGoalCode(final String goalCode) {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createQuery("from Reward r where r.goalCode = ?1");
			query.setParameter(1, goalCode);
			return transformEntityToView(query.getResultList());
		} finally {
			close(em);
		}
	}

	
	private List<RewardView> transformEntityToView(List<Reward> rewards) {
		List<RewardView> rewardViews = new ArrayList<RewardView>();
		for(final Reward reward : rewards) {
			final RewardView rewardView = new RewardView();
			rewardView.setRewardId(reward.getRewardId());
			rewardView.setRewardCode(reward.getRewardCode());
			rewardView.setGoalCode(reward.getGoalCode());
			rewardView.setImage(reward.getImage());
			rewardView.setName(reward.getName());
			rewardView.setStory(reward.getStory());
			rewardView.setExpiryDate(getFormattedDate(reward.getExpiryDate()));
			rewardView.setDate(getFormattedDate(reward.getDate()));
			rewardViews.add(rewardView);
		}
		return rewardViews;
	}
	
	public List<String> getRewardsReportForUser(final String userCode, final String goalCode) {

		final EntityManager em = AdminPersistenceFactory.getPersistenceManager();
		try{
			final Query query = em.createNativeQuery("SELECT  COALESCE(COUNT(ur.REWARD_CODE), 0) AS month FROM ( SELECT 1 AS Month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 ) m LEFT JOIN ss_tr_user_reward ur ON month(ur.DATE) = m.Month and ur.USER_CODE=?1 and ur.GOAL_CODE =?2 GROUP BY m.Month ORDER BY m.Month");
			query.setParameter(1, userCode);
			query.setParameter(2, goalCode);
			return query.getResultList();
		} finally {
			close(em);
		}
	}
}
