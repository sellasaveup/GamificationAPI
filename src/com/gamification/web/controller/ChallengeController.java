package com.gamification.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.web.manager.WebManager;
import com.gamification.web.view.Challenge;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ChallengeController
 */
public class ChallengeController extends HttpServlet {
	
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    public void doPost(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
    
    String action = request.getParameter("action");
    WebManager webManager = new WebManager();
    List<Challenge> challengeList = null;
    if ( action != null) 
    {
            

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response.setContentType("application/json");

            if (action.equals("list"))  {
            	challengeList = webManager.getChallengeList();
            
                    try {                                                                       
                    
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", challengeList);
                    
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
            		Challenge challenge = new Challenge();
                    String status = null;
                    if (request.getParameter("id") != null) {
                            int rewardId = Integer.parseInt(request.getParameter("id"));
                            challenge.setId(rewardId);
                    }

                    if (request.getParameter("description") != null) {
                            String description = request.getParameter("description");
                            challenge.setDescription(description);
                    }

                    if (request.getParameter("userAction") != null) {
                            String userAction = request.getParameter("userAction");
                            challenge.setUserAction(userAction);
                    }

                    if (request.getParameter("point") != null) {
                            int point = Integer.parseInt(request.getParameter("point"));
                            challenge.setPoint(point);
                    }
                    if (request.getParameter("subjectType") != null) {
                        String subjectType = request.getParameter("subjectType");
                        challenge.setSubjectType(subjectType);
                    }
                    
                    if (request.getParameter("imageUrl") != null) {
                        String imageUrl = request.getParameter("imageUrl");
                        challenge.setImageUrl(imageUrl);
                    }
                    
                    if (request.getParameter("occurrence") != null) {
                        int occurrence = Integer.parseInt(request.getParameter("occurrence"));
                        challenge.setOccurrence(occurrence);
                    }
                    
                    if (request.getParameter("expiryDate") != null) {
                        String expiryDate = request.getParameter("expiryDate");
                        challenge.setExpiryDate(expiryDate);
                    }
                    
                    if (request.getParameter("goal") != null) {
                        String goal = request.getParameter("goal");
                        challenge.setGoal(goal);
                    }

                    if (action.equals("create")) {
                    	status = webManager.addChallenge(challenge);
                    } else if (action.equals("update")) {
                    	status = webManager.updateChallenge(challenge);
                    }
                    if(status != null && status.equals("SUCCESS")) {
                    	JSONROOT.put("Result", "OK");
                        JSONROOT.put("Record", challenge);
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
        	  int rewardId = Integer.parseInt(request.getParameter("id"));
        	  System.out.println("rewardId-->"+rewardId);
        	  webManager.deleteChallenge(rewardId);
              JSONROOT.put("Result", "OK");

              String jsonArray = gson.toJson(JSONROOT);
              response.getWriter().print(jsonArray);
          }
    }
 }
}
