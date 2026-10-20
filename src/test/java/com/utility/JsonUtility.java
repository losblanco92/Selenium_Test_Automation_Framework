package com.utility;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {
	private static ObjectMapper obj;

	public static <T> T readJson(String path, Class<T> clazz) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		
		if(is== null)
		{
			
			throw new RuntimeException( "JSON file not found in classpath: " + path);
		}
		
		try {

			obj = new ObjectMapper();
			return obj.readValue(is, clazz);
            } catch (

		IOException e) {
            	e.printStackTrace();
            	throw new RuntimeException("Failed to read JSON file: " + path, e);
		}
	}

}
