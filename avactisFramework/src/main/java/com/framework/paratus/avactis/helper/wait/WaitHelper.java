package com.framework.paratus.avactis.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.annotation.Untainted;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	private Logger logger = Logger.getLogger(WaitHelper.class);
	private WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * implicit wait method
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeout, unit);
		logger.info("implicit wait have been set to  : " + timeout);
	}

	/**
	 * this for getting explicit wait
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryMiliSeconds
	 * @return
	 */
	private WebDriverWait getWait(long timeOutInSeconds, long pollingEveryMiliSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryMiliSeconds));

		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);

		return wait;
	}

	/**
	 * waiting for element to visible with polling interval time
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryMiliSeconds
	 */
	public void waitForElementVisibleWithPollingInterval(WebElement element, long timeOutInSeconds,
			long pollingEveryMiliSeconds) {

		logger.info("waiting for : " + element.toString() + " for " + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryMiliSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.info("element is visible");
	}

	/**
	 * waiting for element to be clickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementToBeClickable(WebElement element, long timeOutInSeconds) {

		logger.info("waiting for element : " + element.toString() + " for " + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		logger.info("element is clickable now");
	}

	/**
	 * this method is for invisibility of element
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementNotPresent(WebElement element, long timeOutInSeconds) {

		logger.info("waiting for element  : " + element.toString() + " for " + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
		logger.info("element is invisible now");
	}

	/**
	 * this method is for frame to be available and switchmto it
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForFrameToBeAvaibleAndSwichToIt(WebElement element, long timeOutInSeconds) {
		logger.info("waiting for element : " + element.toString() + " for " + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		logger.info("frame is available and switched");
	}

	/**
	 * this will give us a fluentwait 
	 * @param timeOutInSeconds
	 * @param pollingEveryMiliSeconds
	 * @return
	 */
	private Wait<WebDriver>  getFluentWait(long timeOutInSeconds, long pollingEveryMiliSeconds) {
		
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryMiliSeconds)).ignoring(NoSuchElementException.class);
		
		return fwait;
	}
	
	/**
	 * this method is used for visibility of element using fluent wait
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryMiliSeconds
	 * @return
	 */
	public WebElement waitForElement(WebElement element,long timeOutInSeconds, long pollingEveryMiliSeconds) {
		logger.info("waiting for element : "+element.toString()+" for "+timeOutInSeconds+ " seconds");
		Wait<WebDriver> fluentWait = getFluentWait(timeOutInSeconds, pollingEveryMiliSeconds);
		logger.info("element is visible now");
		return fluentWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForPageLoadTimeOut(long timeOutInSeconds, TimeUnit unit) {
		logger.info("waiting for page load for time unit "+unit+" seconds");
		driver.manage().timeouts().pageLoadTimeout(timeOutInSeconds, unit);
		logger.info("page is loaded");
	}
}
