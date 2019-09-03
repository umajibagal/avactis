package com.framework.paratus.avactis.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;

public class AlertHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		logger.info("AlertHelper object is created ");
	}

	/**
	 * This method will return alert
	 * @return
	 */
	public Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		logger.info("driver test : " + alert.getText());
		return alert;
	}

	/**
	 * this method will accept alert
	 */
	public void acceptAlert() {
		getAlert().accept();
		logger.info("alert accepted");
	}

	/**
	 * this method will cancel the alert
	 */
	public void dismissAlert() {
		getAlert().accept();
		logger.info("alert dismissed");
	}
	
	/**
	 * this method will return the text of alert
	 */
	public String getAlertText() {
		String text = getAlert().getText();
		logger.info("alert text " + text);
		return text;
	}

	/**
	 * this method will check alert is present 
	 */
	public boolean isAlertPresent() {
		try {
			getAlert();
			logger.info("alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			logger.info(e.getCause());
			return false;
		}
	}
	
	/**
	 * this will accept alert if present
	 */
	public void acceptIfAlertPresent() {
		if(isAlertPresent()) {
			acceptAlert();
		}else {
			logger.info("alert is not present");
		}
	}
	
	/**
	 * this method will cancel alert if present
	 */
	public void dismissIfAlertPresent() {
		if(isAlertPresent()) {
			dismissAlert();
		}else {
			logger.info("alert is not present");
		}
	}
	
	/**
	 * this method accept and send text to alert 
	 * @param text
	 */
	public void acceptAlertWithSendKeys(String text) {
		if(isAlertPresent()) {
			getAlert().sendKeys(text);
			logger.info("Alert text : "+text);
		}
	}
	
	
}
