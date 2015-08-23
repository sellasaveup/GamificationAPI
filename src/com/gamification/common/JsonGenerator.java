package com.gamification.common;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonGenerator {
	public String getJson(Map<String, Object> jsonRoot) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(jsonRoot);
	}
}
