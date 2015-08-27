package com.gamification.api.controller.badge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.badge.Badge;
import com.gamification.api.persistence.badge.BadgeDao;

@SuppressWarnings("serial")
public class RetrieveBadge extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		final String goalCode = request.getParameter("goalCode");
		if(goalCode != null) {
			JSONROOT.put("Records", new BadgeDao().getBadgeByGoalCode(goalCode));
		}
		
		final String badge = request.getParameter("badge");
		if(badge != null) {
			List<String> badges = new ArrayList<String>();
			for(final Badge b : new BadgeDao().retrieveAll()) {
				badges.add(b.getBadgeCode());
			}
			JSONROOT.put("Options", badges);
		}
	}
}
