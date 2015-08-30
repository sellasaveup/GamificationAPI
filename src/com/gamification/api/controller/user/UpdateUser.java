package com.gamification.api.controller.user;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.controller.AdminController;
import com.gamification.api.interfaces.persistence.user.User;
import com.gamification.api.persistence.user.UserDao;
import com.gamification.web.RequestTransformer;

public class UpdateUser extends AdminController {

	@Override
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONROOT = new HashMap<String, Object>();
		JSONROOT.put(RESULT, TRANSITION_OK);
		
		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request, getServletContext().getRealPath("/") + "/uploads/users");
		final User user = new User();
		user.setUserId(Long.valueOf(inputs.get("userId")));
		user.setName(inputs.get("name"));
		user.setImage(inputs.get("image"));
		user.setUserType(inputs.get("userType"));
		user.setDate(Calendar.getInstance().getTime());
		user.setStatus(inputs.get("status"));
		user.setDate(getParsedDate(inputs.get("date")));
		user.setNickName(inputs.get("nickName"));
		user.setUserCode(inputs.get("userCode"));
		new UserDao().update(user);
        JSONROOT.put("Record", user);
	}
}
