package com.framework.paratus.avactis.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.framework.paratus.avactis.helper.resource.ResourceHelper;

public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class cls) {

		if (root)
			return Logger.getLogger(cls);

		PropertyConfigurator.configure(ResourceHelper.getResouce("/src/main/resources/configfile/log4j.properties"));

		root = true;
		return Logger.getLogger(cls);

	}

	public static void main(String[] args) {
		Logger log = getLogger(LoggerHelper.class);
		log.info("demo");
		log.info("hello");
	}
}
