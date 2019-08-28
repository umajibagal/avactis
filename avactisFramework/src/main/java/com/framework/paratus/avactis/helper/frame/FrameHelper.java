package com.framework.paratus.avactis.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;

public class FrameHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * switch frame by index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		logger.info("switched to "+index+" frame");
	}
	
	/**
	 * switch frame by name or id
	 * @param nameOrId
	 */
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
		logger.info("switched to "+nameOrId+" frame");
	}
	
	/**
	 * switch frame by web element
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		logger.info("switched to "+frameElement.toString()+" frame");
	}
}
