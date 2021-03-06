package com.gamification.api.controller.badge;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.persistence.badge.BadgeDao;

@SuppressWarnings("serial")
public class DeleteBadge extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		new BadgeDao().delete(Long.valueOf(request.getParameter("badgeId")));
	}
}
