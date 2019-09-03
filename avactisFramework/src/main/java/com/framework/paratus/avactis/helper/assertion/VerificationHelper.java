package com.framework.paratus.avactis.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;

public class VerificationHelper {
	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			logger.info("element is present : " + element.getText());
			return true;
		} catch (Exception e) {
			logger.error("element is not present", e.getCause());
			return false;
		}
	}

	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			logger.info("element is Displayed : " + element.getText());
			return false;
		} catch (Exception e) {
			logger.info("element is not Displayed" + element.getText());
			return true;
		}
	}

	public String readTextFromElement(WebElement element) {
		if (element == null) {
			logger.info("web element is null");
			return null;
		}

		if (isDisplayed(element)) {
			logger.info("element text is :" + element.getText());
			return element.getText();

		} else {
			return null;
		}
	}

	public String getText(WebElement element) {

		if (element == null) {
			logger.info("web element is null");
			return null;
		}

		if (isDisplayed(element)) {
			logger.info("element text is :" + element.getText());
			return element.getText();

		} else {
			return null;
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
