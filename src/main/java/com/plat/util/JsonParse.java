package com.plat.util;

import java.io.File;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParse {
	public static void main(String[] args) {
		try {
			String menuFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\menu.json"; 
			JsonParser jp = new JsonParser();
			JsonArray jarray = (JsonArray) jp.parse(new FileReader(new File(menuFilePath)));
			for (int i = 0; i < jarray.size(); i++) {
				JsonObject jobject = (JsonObject) jarray.get(i);
				System.out.println(jobject.get("label"));
				System.out.println(jobject.get("code"));
				JsonArray jChild = jobject.getAsJsonArray("child");
				System.out.println(jChild);
				System.out.println(jChild.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
