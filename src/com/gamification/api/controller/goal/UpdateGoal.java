package com.gamification.api.controller.goal;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.goal.Goal;
import com.gamification.api.persistence.goal.GoalDao;
import com.gamification.web.RequestTransformer;

public class UpdateGoal extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);

		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request, getServletContext().getRealPath("/") , "/img/goals");
		final Goal goal = new GoalDao().retrieve(Long.valueOf(inputs.get("goalId")));
		goal.setName(inputs.get("name"));
		goal.setGoalCode(inputs.get("goalCode"));
		goal.setExpiryDate(getParsedDate(inputs.get("expiryDate")));
		goal.setStory(inputs.get("story"));
		if(inputs.get("image") != null) {
			goal.setImage(inputs.get("image"));
		}
		goal.setUserType(inputs.get("userType"));
		goal.setDate(Calendar.getInstance().getTime());
		goal.setStatus(inputs.get("status"));
		new GoalDao().update(goal);
		JSONROOT.put("Record", goal);
	}
}
