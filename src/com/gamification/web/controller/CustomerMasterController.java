package com.gamification.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamification.api.view.CustomerMaster;
import com.gamification.web.manager.WebManager;
import com.gamification.web.view.Reward;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class CustomerMasterController
 */
public class CustomerMasterController extends HttpServlet {
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    public void doPost(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
    
    String action = request.getParameter("action");
    WebManager webManager = new WebManager();
    List<CustomerMaster> customerList = null;
    if ( action != null) 
    {
            

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response.setContentType("application/json");

            if (action.equals("list"))  {
            	customerList = webManager.getCustomerList();
            
                    try {                                                                       
                    
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", customerList);
                    
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
            		CustomerMaster customerMaster = new CustomerMaster();
                    String status = null;
                    if (request.getParameter("custId") != null) {
                            int custId = Integer.parseInt(request.getParameter("custId"));
                            customerMaster.setCustId(custId);
                    }

                    if (request.getParameter("customerName") != null) {
                            String customerName = request.getParameter("customerName");
                            customerMaster.setCustomerName(customerName);
                    }

                    if (request.getParameter("customerAvatar") != null) {
                            String customerAvatar = request.getParameter("customerAvatar");
                            customerMaster.setCustomerAvatar(customerAvatar);
                    }

                    if (request.getParameter("points") != null) {
                            int points = Integer.parseInt(request.getParameter("points"));
                            customerMaster.setPoints(points);
                    }
                    
                    if (request.getParameter("subjectType") != null) {
                        String subjectType = request.getParameter("subjectType");
                        customerMaster.setSubjectType(subjectType);
                }

                    if (action.equals("create")) {
                    	status = webManager.addCustomer(customerMaster);
                    } else if (action.equals("update")) {
                    	status = webManager.updateCustomer(customerMaster);
                    }
                    if(status != null && status.equals("SUCCESS")) {
                    	JSONROOT.put("Result", "OK");
                        JSONROOT.put("Record", customerMaster);
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
        	  int custId = Integer.parseInt(request.getParameter("custId"));
        	  System.out.println("custId-->"+custId);
        	  webManager.deleteCustomer(custId);
              JSONROOT.put("Result", "OK");

              String jsonArray = gson.toJson(JSONROOT);
              response.getWriter().print(jsonArray);
          }
    }
 }
}
