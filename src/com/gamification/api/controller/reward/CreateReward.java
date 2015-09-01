package com.gamification.api.controller.reward;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.reward.Reward;
import com.gamification.api.persistence.reward.RewardDao;
import com.gamification.web.RequestTransformer;

public class CreateReward extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		
		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request, getServletContext().getRealPath("/") + "/uploads/rewards");
		final Reward reward = new Reward();
		reward.setName(inputs.get("name"));
		reward.setRewardCode(inputs.get("rewardCode"));
		reward.setGoalCode(inputs.get("goalCode"));
		reward.setExpiryDate(getParsedDate(inputs.get("expiryDate")));
		reward.setImage(inputs.get("image"));
		reward.setStory(inputs.get("story"));
		reward.setDate(Calendar.getInstance().getTime());
		new RewardDao().create(reward);
        JSONROOT.put("Record", reward);
	}
}
