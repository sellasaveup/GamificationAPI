package com.gamification.api.controller.challenge;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.persistence.challenge.ChallengeDao;

public class DeleteChallenge extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		new ChallengeDao().delete(Long.valueOf(request.getParameter("challengeId")));
	}
}
