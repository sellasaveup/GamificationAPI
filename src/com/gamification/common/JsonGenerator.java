package com.gamification.common;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonGenerator {
	public String getJson(HashMap<String, Object> jsonRoot) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(jsonRoot);
	}
}
