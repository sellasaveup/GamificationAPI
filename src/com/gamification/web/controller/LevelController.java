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
import com.gamification.web.view.Level;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
public class LevelController extends HttpServlet {
	
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String action = request.getParameter("action");
    WebManager webManager = new WebManager();
    List<Level> levelList = null;
    if ( action != null) 
    {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response.setContentType("application/json");

            if (action.equals("list"))  {
            	levelList = webManager.getLevelList();
            
                    try {                                                                       
                    
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", levelList);
                    
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
            		System.out.println(getServletContext().getRealPath("/"));
            		final Map<String,String> inputs = RequestTransformer.getInputsAndUploadFile(request,getServletContext().getRealPath("/") + "/uploads/level");
            		final Level level = new Level();
                    if(inputs.get("levelId") != null) {
                    	level.setLevelId(Long.parseLong(inputs.get("levelId")));
                    }
                    level.setLevelDesc(inputs.get("levelDesc"));
                    level.setImageUrl(inputs.get("imageUrl"));
                    level.setBadgeId(Long.valueOf(inputs.get("badgeId")));
                    level.setRewardId(Long.valueOf(inputs.get("rewardId")));
                    
                    String status = null;
                    if (action.equals("create")) {
                    	status = webManager.addLevel(level);
                    } else if (action.equals("update")) {
                    	status = webManager.updateLevel(level);
                    }
                    if(status != null && status.equals("SUCCESS")) {
                    	JSONROOT.put("Result", "OK");
                        JSONROOT.put("Record", level);
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
        	  Long levelId = Long.parseLong(request.getParameter("levelId"));
        	  webManager.deleteLevel(levelId);
              JSONROOT.put("Result", "OK");
              String jsonArray = gson.toJson(JSONROOT);
              response.getWriter().print(jsonArray);
          }
    }
 }
}