package com.gamification.api.controller.reward;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.reward.Reward;
import com.gamification.api.persistence.reward.RewardDao;
import com.gamification.web.RequestTransformer;

public class UpdateReward extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		
		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request, getServletContext().getRealPath("/") , "/img/rewards");
		final Reward reward = new RewardDao().retrieve(Long.valueOf(inputs.get("rewardId")));
		reward.setName(inputs.get("name"));
		reward.setRewardCode(inputs.get("rewardCode"));
		reward.setGoalCode(inputs.get("goalCode"));
		reward.setExpiryDate(getParsedDate(inputs.get("expiryDate")));
		if(inputs.get("image") != null) {
			reward.setImage(inputs.get("image"));
		}
		reward.setDate(getParsedDate(inputs.get("date")));
		new RewardDao().update(reward);
        JSONROOT.put("Record", reward);
	}
}
