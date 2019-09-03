package com.framework.paratus.avactis.helper.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.paratus.avactis.helper.resource.ResourceHelper;

public class IEBrowser {

	public  InternetExplorerOptions getInternetExplorerOptions() {
		DesiredCapabilities capabalities = DesiredCapabilities.internetExplorer();
		
		capabalities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		capabalities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capabalities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabalities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		
		InternetExplorerOptions options = new InternetExplorerOptions(capabalities);
		
		return options;
		
	}
	
	public WebDriver getIEDriver(InternetExplorerOptions options) {
		
		if(System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.ie.driver",ResourceHelper.getResouce("/src/main/resources/drivers/IEDriverServer.exe"));
			return new InternetExplorerDriver();
		}
		return null;
	}
}
