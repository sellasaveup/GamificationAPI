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
import com.gamification.web.view.Reward;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
public class RewardController extends HttpServlet {
        private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

        public void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
        
        String action = request.getParameter("action");
        WebManager webManager = new WebManager();
        List<Reward> rewardList = null;
        if ( action != null) 
        {

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                response.setContentType("application/json");

                if (action.equals("list"))  {
                	rewardList = webManager.getRewardList();
                
                        try {                                                                       
                        
                        JSONROOT.put("Result", "OK");
                        JSONROOT.put("Records", rewardList);
                        
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
                		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request,getServletContext().getRealPath("/") + "/uploads/reward");
                		final Reward reward = new Reward();
                        if(inputs.get("rewardId") != null) {
                        	reward.setRewardId(Integer.parseInt(inputs.get("rewardId")));
                        }
                        reward.setRewardDesc(inputs.get("rewardDesc"));
                        reward.setRewardPoint(Integer.parseInt(inputs.get("rewardPoint")));
                        reward.setRewardCode(inputs.get("rewardCode"));
                        reward.setImageUrl(inputs.get("imageUrl"));
                        reward.setSubjectType(inputs.get("subjectType"));
                        reward.setGoal(inputs.get("goal"));
                        
                        String status = null;
                        if (action.equals("create")) {
                        	status = webManager.addReward(reward);
                        } else if (action.equals("update")) {
                        	status = webManager.updateReward(reward);
                        }
                        if(status != null && status.equals("SUCCESS")) {
                        	JSONROOT.put("Result", "OK");
                            JSONROOT.put("Record", reward);
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
            	  int rewardId = Integer.parseInt(request.getParameter("rewardId"));
            	  System.out.println("rewardId-->"+rewardId);
            	  webManager.deleteReward(rewardId);
                  JSONROOT.put("Result", "OK");

                  String jsonArray = gson.toJson(JSONROOT);
                  response.getWriter().print(jsonArray);
              }
        }
     }
}