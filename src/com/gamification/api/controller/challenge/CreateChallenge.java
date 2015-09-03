package com.gamification.api.controller.challenge;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.challenge.Challenge;
import com.gamification.api.persistence.challenge.ChallengeDao;
import com.gamification.web.RequestTransformer;

@SuppressWarnings("serial")
public class CreateChallenge extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		
		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request, getServletContext().getRealPath("/") , "/img/challenges");
		final Challenge challenge = new Challenge();
		challenge.setGoalCode(inputs.get("goalCode"));
		challenge.setActionCode(inputs.get("actionCode"));
		challenge.setRewardCode(inputs.get("rewardCode"));
		challenge.setBadgeCode(inputs.get("badgeCode"));
		challenge.setStory(inputs.get("story"));
		challenge.setImage(inputs.get("image"));
		challenge.setExpiryDate(getParsedDate(inputs.get("expiryDate")));
		challenge.setPoints(Long.valueOf(inputs.get("points")));
		challenge.setOccurrence(Integer.valueOf(inputs.get("occurrence")));
		challenge.setDate(Calendar.getInstance().getTime());
		new ChallengeDao().create(challenge);
        JSONROOT.put("Record", challenge);
	}

}
