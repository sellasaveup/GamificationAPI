package com.gamification.api.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class AdminController  extends HttpServlet {
	
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected abstract void doAction(final HttpServletRequest request, final HttpServletResponse response) throws Exception;
}
