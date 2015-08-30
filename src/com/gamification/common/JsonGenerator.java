package com.gamification.common;

import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonGenerator {
	final static Logger logger = Logger.getLogger(JsonGenerator.class);

	public String getJson(Map<String, Object> jsonRoot) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String finalJson = gson.toJson(jsonRoot);
		logger.debug("finalJson-->"+finalJson);
		return finalJson;
	}
}
