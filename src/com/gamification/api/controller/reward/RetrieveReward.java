package com.gamification.api.controller.reward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.persistence.reward.RewardDao;
import com.gamification.api.view.RewardView;

public class RetrieveReward extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		final String goalCode = request.getParameter("goalCode");
		if(goalCode != null) {
			JSONROOT.put("Records", new RewardDao().getRewardByGoalCode(goalCode));
		}
		final String reward = request.getParameter("reward");
		if(reward != null) {
			List<String> rewards = new ArrayList<String>();
			for(final RewardView r : new RewardDao().getRewardByGoalCode(reward)) {
				rewards.add(r.getRewardCode());
			}
			JSONROOT.put("Options", rewards);
		}
	}

}
