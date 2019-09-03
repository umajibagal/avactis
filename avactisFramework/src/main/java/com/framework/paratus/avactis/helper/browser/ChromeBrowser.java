package com.framework.paratus.avactis.helper.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.paratus.avactis.helper.resource.ResourceHelper;

public class ChromeBrowser {

	public ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, chrome);

		// linux
		if (System.getProperty("os.name").contains("Linux"))
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");

		return option;
	}

	public WebDriver getChromeDriver(ChromeOptions options) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResouce("/src/main/resouces/drivers/chromedriver"));
			return new ChromeDriver(options);
		} else if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResouce("/src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(options);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			return new ChromeDriver(options);
		}
		return null;
	}
}
