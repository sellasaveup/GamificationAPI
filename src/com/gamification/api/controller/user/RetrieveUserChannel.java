package com.gamification.api.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.user.UserChannel;
import com.gamification.api.persistence.user.UserChannelDao;

public class RetrieveUserChannel extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		
		final String channel = request.getParameter("channel");
		if(channel != null) {
			List<String> channels = new ArrayList<String>();
			for(final UserChannel u : new UserChannelDao().retrieveAll()) {
				channels.add(u.getUserTypeCode());
			}
			JSONROOT.put("Options", channels);
		}
	}
}
