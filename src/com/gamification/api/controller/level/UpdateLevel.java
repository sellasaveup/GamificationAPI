package com.gamification.api.controller.level;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.level.Level;
import com.gamification.api.persistence.level.LevelDao;
import com.gamification.web.RequestTransformer;

public class UpdateLevel extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);

		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request, getServletContext().getRealPath("/") , "/img/levels");
		final Level level = new LevelDao().retrieve(Long.valueOf(inputs.get("levelId")));
		level.setName(inputs.get("name"));
		level.setGoalCode(inputs.get("goalCode"));
		level.setLevelCode(inputs.get("levelCode"));
		level.setRewardCode(inputs.get("rewardCode"));
		level.setBadgeCode(inputs.get("badgeCode"));
		level.setStory(inputs.get("story"));
		level.setStartPoint(Long.valueOf(inputs.get("startPoint")));
		level.setEndPoint(Long.valueOf(inputs.get("endPoint")));
		level.setPriority(Integer.valueOf(inputs.get("priority")));
		if(inputs.get("image") != null) {
			level.setImage(inputs.get("image"));
		}
		level.setDate(Calendar.getInstance().getTime());
		new LevelDao().update(level);
		JSONROOT.put("Record", level);
	}
}
