package com.framework.paratus.avactis.helper.select;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;

public class DropDownHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		logger.info("DropDown object is created..");
	}

	/**
	 * this method will select drop down using selectUsingValue
	 * 
	 * @param element
	 * @param value
	 */
	public void selectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		logger.info("selectUsingValue and value is : " + value);
	}

	/**
	 * this method will select drop down using selectUsingIndex
	 * 
	 * @param element
	 * @param index
	 */
	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		logger.info("selectUsingIndex and index is : " + index);
	}

	/**
	 * this method will select drop down using selectUsingVisibleText
	 * 
	 * @param element
	 * @param text
	 */
	public void selectUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		logger.info("selectUsingVisibleText and text is : " + text);
	}

	/**
	 * this method will deselect drop down using deselectUsingValue
	 * 
	 * @param element
	 * @param value
	 */
	public void deselectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
		logger.info("deselectUsingValue and value is : " + value);
	}

	/**
	 * this method will deselect drop down using deselectUsingIndex
	 * 
	 * @param element
	 * @param index
	 */
	public void deselectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
		logger.info("deselectUsingIndex and index is : " + index);
	}

	/**
	 * this method will deselect drop down using deselectUsingVisibleText
	 * 
	 * @param element
	 * @param text
	 */
	public void deselectUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
		logger.info("deselectUsingVisibleText and text is : " + text);
	}

	/**
	 * this method will return all drop down data
	 * @param element
	 * @return
	 */
	public List<String> getAllDropDownData(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> allData = new ArrayList<String>();
		for (WebElement ele : elementList) {
			allData.add(ele.getText());
			logger.info("drop all down data added to : "+ele.getText());
		}
		return allData;
	}
	
	
	/**
	 * this method will return all selected drop down data
	 * @param element
	 * @return
	 */
	public List<String> getAllSelectedDropDownData(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getAllSelectedOptions();
		List<String> selectedData = new ArrayList<String>();
		for (WebElement ele : elementList) {			
			selectedData.add(ele.getText());
			logger.info("drop down selected data added to : "+ele.getText());
		}
		return selectedData;
	}

	/**
	 * this will deselect all options
	 * @param element
	 * @param text
	 */
	public void deselectAllDropDownData(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
		logger.info("deselected all options");
	}

}
