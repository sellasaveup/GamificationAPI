package com.gamification.api.controller.badge;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.badge.Badge;
import com.gamification.api.persistence.badge.BadgeDao;
import com.gamification.web.RequestTransformer;

@SuppressWarnings("serial")
public class CreateBadge extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		
		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request, getServletContext().getRealPath("/") + "/uploads/badges");
		final Badge badge = new Badge();
		badge.setName(inputs.get("name"));
		badge.setBadgeCode(inputs.get("badgeCode"));
		badge.setGoalCode(inputs.get("goalCode"));
		badge.setExpiryDate(getParsedDate(inputs.get("expiryDate")));
		badge.setStory(inputs.get("story"));
		badge.setImage(inputs.get("image"));
		badge.setDate(getParsedDate(inputs.get("date")));
		new BadgeDao().create(badge);
        JSONROOT.put("Record", badge);
	} 
}
