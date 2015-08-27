package com.gamification.api.controller.level;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.persistence.level.LevelDao;

public class RetrieveLevel extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		final String goalCode = request.getParameter("goalCode");
		if(goalCode != null) {
			JSONROOT.put("Records", new LevelDao().getLevelByGoalCode(goalCode));
		}
	}
}
