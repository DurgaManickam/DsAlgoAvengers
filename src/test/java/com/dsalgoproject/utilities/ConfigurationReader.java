package com.dsalgoproject.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Stores the project configuration data in a key-value pair such as url's,
 * browser types, timeouts
 */
public class ConfigurationReader {

	private Properties properties;

	public ConfigurationReader(String filePath) {
		try {
			FileInputStream fileInput = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}

	public String getAppURL() {
		return properties.getProperty("appURL");
	}

	public int getImplicitWaitTimeout() {
		return Integer.parseInt(properties.getProperty("implicitWaitTimeout"));
	}

}
