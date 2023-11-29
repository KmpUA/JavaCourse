package org.lab1.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	private static final Properties properties = new Properties();

	static {
		try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
			if (input == null) {
				System.out.println("Sorry, unable to find application.properties");
			}
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}

