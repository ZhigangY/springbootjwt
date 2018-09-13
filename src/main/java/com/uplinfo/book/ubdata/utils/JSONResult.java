package com.uplinfo.book.ubdata.utils;

import org.json.JSONObject;

public class JSONResult {
	public static String fillResultString(Integer status, String message, Object result) {
		JSONObject jsonObject = new JSONObject() {
			{
				put("status", status);
				put("message", message);
				put("data", result);
			}
		};

		return jsonObject.toString();
	}

	public static JSONObject success(Object object) {
		JSONObject jsonObject = new JSONObject() {
			{
				put("status", 200);
				put("message", "OK");
				put("data", object);
			}
		};
		return jsonObject;
	}
}
