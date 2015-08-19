package com.gamification.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.web.RequestTransformer;
import com.gamification.web.manager.WebManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class BadgeMasterController
 */
@SuppressWarnings("serial")
public class BadgeMasterController extends HttpServlet {
	/*
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    public void doPost(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
    
    String action = request.getParameter("action");
    WebManager webManager = new WebManager();
    List<BadgeMaster> badgeMasterList = null;
    if ( action != null) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response.setContentType("application/json");

            if (action.equals("list"))  {
            	badgeMasterList = webManager.getBadgeList();
            
                    try {                                                                       
                    
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", badgeMasterList);
                    
                    String jsonArray = gson.toJson(JSONROOT);
                    System.out.println(jsonArray);
                    response.getWriter().print(jsonArray);
                    }
                    catch(Exception ex){
                            JSONROOT.put("Result", "ERROR");
                            JSONROOT.put("Message", ex.getMessage());
                            String error = gson.toJson(JSONROOT);
                            response.getWriter().print(error);
                    }  
                    
            } else if (action.equals("create") || action.equals("update")) {
            	try {
                    final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request,getServletContext().getRealPath("/") + "/uploads/badge");
                    final BadgeMaster badgeMaster = new BadgeMaster();
                    if(inputs.get("badgeId") != null) {
                    	badgeMaster.setBadgeId(Integer.parseInt(inputs.get("badgeId")));
                    }
                    badgeMaster.setBadgeName(inputs.get("badgeName"));
                    badgeMaster.setBadgeCode(inputs.get("badgeCode"));
                    badgeMaster.setImageUrl(inputs.get("imageUrl"));
                    badgeMaster.setSubjectType(inputs.get("subjectType"));
                    badgeMaster.setGoal(inputs.get("goal"));
                    String status = null;
                    if (action.equals("create")) {
                    	status = webManager.addBadge(badgeMaster);
                    } else if (action.equals("update")) {
                    	status = webManager.updateBadge(badgeMaster);
                    }
                    if(status != null && status.equals("SUCCESS")) {
                    	JSONROOT.put("Result", "OK");
                        JSONROOT.put("Record", badgeMaster);
                    } else {
                    	JSONROOT.put("Result", "ERROR");
                        JSONROOT.put("Message", "DB Problem");
                    }
                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
            	} catch (Exception ex) {
            		JSONROOT.put("Result", "ERROR");
            		JSONROOT.put("Message", ex.getMessage());
            		String error = gson.toJson(JSONROOT);
            		response.getWriter().print(error);
            	}
            
          } else if(action.equals("delete")) {
        	  int badgeId = Integer.parseInt(request.getParameter("badgeId"));
        	  System.out.println("badgeId-->"+badgeId);
        	  webManager.deleteBadge(badgeId);
              JSONROOT.put("Result", "OK");

              String jsonArray = gson.toJson(JSONROOT);
              response.getWriter().print(jsonArray);
          }
    }
 }*/
}
