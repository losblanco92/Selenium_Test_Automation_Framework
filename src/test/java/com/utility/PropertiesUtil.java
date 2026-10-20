package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties properties = new Properties();
	private static String path;
	private static String env;

	static {

		env = System.getProperty("env", "qa");

		switch (env.toLowerCase().trim()) {
		case "qa" -> path = "config/QA.properties";
		case "uat" -> path = "config/UAT.properties";
		case "dev" -> path = "config/DEV.properties";
		default -> path = "config/QA.properties";

		}

		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		if (stream == null) {

			throw new RuntimeException("File not found in the path " + path);
		}

		else {

			try {
				properties.load(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static String getProperty(String key) {

		return properties.getProperty(key.toUpperCase());

	}

}
