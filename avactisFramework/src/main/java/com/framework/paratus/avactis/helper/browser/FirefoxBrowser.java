package com.framework.paratus.avactis.helper.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.paratus.avactis.helper.resource.ResourceHelper;

public class FirefoxBrowser {

	public FirefoxOptions getFirefoxOptions() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);

		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		capabilities.setCapability("marionette", true);

		FirefoxOptions options = new FirefoxOptions(capabilities);

		// linux
		if (System.getProperty("os.name").contains("Linux")) {
			options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return options;
	}

	public WebDriver getFirefoxDriver(FirefoxOptions options) {

		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResouce("/src/resouces/drivers/geckodriver"));
			return new FirefoxDriver(options);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.gecko.driver", ResourceHelper.getResouce("/src/resouces/drivers/geckodriver.exe"));
			return new FirefoxDriver(options);
		} else if(System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			return new FirefoxDriver(options);
		}
			return null;
	}
}
