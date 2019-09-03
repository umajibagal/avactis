package com.framework.paratus.avactis.helper.browser.config;

import com.framework.paratus.avactis.helper.browser.BrowserType;

public interface ConfigReader {

	public int getImplicitWaitTimeout();
	public int getExplicitWaitTimeout();
	public int getPageLoadTimeout();
	public BrowserType getBrowserType();
}
