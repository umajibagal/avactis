package com.framework.paratus.avactis.helper.resource;

public class ResourceHelper {

	public static String getResouce(String path) {

		return System.getProperty("user.dir") + path;

	}
	public static void main(String[] args) {
		System.out.println(getResouce("/src/main/resources/configfile/log4j.properties"));
	}

}
