package com.framework.paratus.avactis.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;

public class WindowHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(WindowHelper.class);
	
	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method is for switch window to parent
	 */
	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
		logger.info("window swithced to parent now");
	}
	
	/**
	 * this method is for window switch by index
	 * @param index
	 */
	public void switchToWindow(int index) {
		logger.info("switching to window : "+index);
		Set<String> windows = getAllWindowHandles();
		int i=1;
		for (String window : windows) {
			if( i == index)
				driver.switchTo().window(window);
			
			i++;
		}
	}
	
	/**
	 * this method is for getting all window handles
	 * @return
	 */
	public Set<String> getAllWindowHandles(){
		return driver.getWindowHandles();
	}
	
	public String getParentWindowHandle() {
		return driver.getWindowHandle();
	}
	/**
	 * this method is for closing all tabs and switch to main window
	 */
	public void closeAllTabsAndSwitchToMainWindow() {
		
		logger.info("closing all the child windows");
		
		Set<String> windows = getAllWindowHandles();
		String parentWindow  = getParentWindowHandle();
		
		for (String window : windows) {		
			if(!window.equalsIgnoreCase(parentWindow))
				driver.close();
		}
				
		driver.switchTo().window(parentWindow);
		logger.info("switched to parent window");
	}
	
	/**
	 * this method for navigate back
	 */
	public void navigateBack() {
		logger.info("navigating back");
		driver.navigate().back();
	}
	
	/**
	 * this method for navigate forward
	 */
	public void navigateForward() {
		logger.info("navigating forward");
		driver.navigate().forward();
	}
}
