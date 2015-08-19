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
 * Servlet implementation class ChallengeController
 */
@SuppressWarnings("serial")
public class ChallengeController extends HttpServlet {/*
	
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
            		
            		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request,getServletContext().getRealPath("/") + "/uploads/challenge");
            		final Challenge challenge = new Challenge();
                    if(inputs.get("id") != null) {
                    	challenge.setId(Integer.parseInt(inputs.get("id")));
                    }
                    challenge.setDescription(inputs.get("description"));
                    challenge.setUserAction(inputs.get("userAction"));
                    challenge.setPoint(Integer.parseInt(inputs.get("point")));
                    challenge.setSubjectType(inputs.get("subjectType"));
                    challenge.setImageUrl(inputs.get("imageUrl"));
                    challenge.setOccurrence(Integer.parseInt(inputs.get("occurrence")));
                    challenge.setExpiryDate(inputs.get("expiryDate"));
                    challenge.setGoal(inputs.get("goal"));
                    
                    String status = null;
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
 }*/
}
