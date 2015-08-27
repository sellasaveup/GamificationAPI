package com.gamification.api.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
public abstract class AdminController  extends HttpServlet {
	
	protected static final String RESULT = "Result";
	protected static final String TRANSITION_OK = "OK"; 
	
	protected Map<String, Object> JSONROOT;
	
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		try {
			doAction(request, response);
			 setResponse(response);
		} catch(final Exception e) {
			e.printStackTrace();
			JSONROOT.put(RESULT, "ERROR");
            JSONROOT.put("Message", e.getMessage());
            setResponse(response);
		}
	}

	protected void setResponse(final HttpServletResponse response) throws IOException {
		 final String json = new GsonBuilder().setPrettyPrinting().create().toJson(JSONROOT);
		 System.out.println(json);
		 response.setContentType("application/json");
		 response.getWriter().print(json);
	}
	
	protected Date getParsedDate(String date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}
	
	protected abstract void doAction(final HttpServletRequest request, final HttpServletResponse response) throws Exception;
}
