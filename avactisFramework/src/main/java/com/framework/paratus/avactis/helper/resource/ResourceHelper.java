package com.framework.paratus.avactis.helper.resource;

public class ResourceHelper {

	public static String getResouce(String path) {
		return System.getProperty("user.dir") + path;

	}
}
