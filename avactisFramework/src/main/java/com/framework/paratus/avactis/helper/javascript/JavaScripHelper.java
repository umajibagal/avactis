package com.framework.paratus.avactis.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;

public class JavaScripHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(JavaScripHelper.class);

	public JavaScripHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * this method for script 
	 * @param script
	 * @return
	 */
	public Object excuteJScript(String script) {

		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		return javaScript.executeScript(script);
	}

	/**
	 * this method is for script executor with argument 
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeJScript(String script, Object... args) {

		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		return javaScript.executeScript(script, args);
	}

	/**
	 * this method for scroll elemtn
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		logger.info("scroll to element...");
		executeJScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}

	/**
	 * this method scroll element and click
	 * @param element
	 */
	public void scrollElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		logger.info("element is clicked");
	}

	/**
	 * this method scrolling in to view
	 * @param element
	 */
	public void scrollInToView(WebElement element) {
		executeJScript("argumentd[0].scrollIntoView()", element);
		logger.info("scroll till element");
	}

	/**
	 * this method will scroll in view and click on element
	 * @param element
	 */
	public void scrollInToViewAndClick(WebElement element) {
		scrollElementAndClick(element);
		element.click();
		logger.info("element is clicked" + element.toString());
	}

	/**
	 * this method scroll page vertically down
	 */
	public void scrollDownVertically() {
		logger.info("scroll to vertically down");
		excuteJScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * this method scroll page vertically up
	 */
	public void scrollUpVertically() {
		logger.info("scroll to vertically up");
		excuteJScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	/**
	 * this method scroll down page by pixel
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		logger.info("scroll down page by "+pixel+" pixel");
		excuteJScript("window.scrollBy(0,"+pixel+")");
	}

	/**
	 * this method scroll up page by pixel
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel) {
		logger.info("scroll up page by "+pixel+" pixel");
		excuteJScript("window.scrollBy(0,-"+pixel+")");
	}
	
	/**
	 * this method zoom page by 100%
	 */
	public void zoomInBy100Percentage() {
		logger.info("page zoomed by 100%");
		excuteJScript("document.body.style.zoom=100%");
	}
	
	/**
	 * this method is for customize zoom by pixel 
	 * @param pixel
	 */
	public void zoomInByPercentage(int pixel) {
		logger.info("page zoomed by "+pixel+"%");
		excuteJScript("document.body.style.zoom="+pixel+"%");
	}

	/**
	 * this method will click on element
	 */
	public void clickElement(WebElement element) {
		logger.info(element.toString()+" is clicked");
		executeJScript("arguments[0].click();", element);
	}
}
