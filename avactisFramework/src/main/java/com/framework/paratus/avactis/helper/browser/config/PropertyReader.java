package com.framework.paratus.avactis.helper.browser.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.framework.paratus.avactis.helper.browser.BrowserType;
import com.framework.paratus.avactis.helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {

	static FileInputStream fis;
	static Properties prop;

	public PropertyReader() {
		try {
			String path = "/src/main/resources/configfile/config.properties";
			fis = new FileInputStream(new File(ResourceHelper.getResouce(path)));
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getImplicitWaitTimeout() {
		return Integer.parseInt(prop.getProperty("implicitwait"));
	}

	public int getExplicitWaitTimeout() {
		return Integer.parseInt(prop.getProperty("explicitwait"));
	}

	public int getPageLoadTimeout() {
		return Integer.parseInt(prop.getProperty("pageloadtimeout"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(prop.getProperty("browsertype"));
	}

}
