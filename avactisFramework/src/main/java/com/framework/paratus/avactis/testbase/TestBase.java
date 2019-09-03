package com.framework.paratus.avactis.testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework.paratus.avactis.helper.browser.BrowserType;
import com.framework.paratus.avactis.helper.browser.ChromeBrowser;
import com.framework.paratus.avactis.helper.browser.FirefoxBrowser;
import com.framework.paratus.avactis.helper.browser.IEBrowser;
import com.framework.paratus.avactis.helper.browser.config.ObjectReader;
import com.framework.paratus.avactis.helper.browser.config.PropertyReader;
import com.framework.paratus.avactis.helper.logger.LoggerHelper;
import com.framework.paratus.avactis.helper.resource.ResourceHelper;
import com.framework.paratus.avactis.helper.wait.WaitHelper;
import com.framework.paratus.avactis.utils.ExtentReportManagerHelper;

public class TestBase {

	public static ExtentReports extent;
	public static ExtentTest test;

	private Logger logger = LoggerHelper.getLogger(TestBase.class);

	protected WebDriver driver;
	public static File reportDirectory;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentReportManagerHelper.getInstance();
	}

	@BeforeClass
	public void beforeClass() {
		test = extent.createTest(getClass().getName());
	}

	@BeforeTest
	public void beforeTest() {
		ObjectReader.reader = new PropertyReader();
		reportDirectory = new File(ResourceHelper.getResouce("/src/main/resources/screenshots")); 
		setUpDriver(ObjectReader.reader.getBrowserType());
	}
	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + " test started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " PASSED");
			String imagePath = captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		extent.flush();
	}

	public WebDriver getBrowserObject(BrowserType browserType) throws Exception {
		switch (browserType) {
		case Chrome:

			ChromeBrowser chrome = new ChromeBrowser(); // getting the object of chrome browser clas
			return chrome.getChromeDriver(chrome.getChromeOptions()); // returning driver

		case Firefox:

			FirefoxBrowser firefox = new FirefoxBrowser(); // getting firefox browser object
			return firefox.getFirefoxDriver(firefox.getFirefoxOptions()); // returning firefox driver

		case Iexplorer:

			IEBrowser ie = new IEBrowser(); // getting ie browser object
			InternetExplorerOptions options = ie.getInternetExplorerOptions(); // getting capabilities
			return ie.getIEDriver(options); // returning ie driver

		default:

			logger.info("driver not found for  : " + browserType.name()); // specific browser type not found
			throw new Exception("Driver not found " + browserType.name()); // throwing exeption
		}
	}

	public void setUpDriver(BrowserType browserType) {
		try {
			driver = getBrowserObject(browserType);
			logger.info("Initialize driver : " + driver.hashCode());
			WaitHelper wait = new WaitHelper(driver);
			wait.setPageLoadTimeout(ObjectReader.reader.getPageLoadTimeout(), TimeUnit.SECONDS);
			wait.setImplicitWait(ObjectReader.reader.getImplicitWaitTimeout(), TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String captureScreenshot(String fileName) {
		if(driver == null) {
			logger.info("driver is null");
			return null;
		}
		
		if(fileName == "")
			fileName = "blank";
		File destFile = null;
		
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(reportDirectory+"/"+fileName+"_"+formater.format(calender.getTime())+".png");
			FileHandler.copy(sourceFile, destFile);
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"/"+"'><img src='"+destFile.getAbsolutePath()+"' height='100' widht='100'/></a>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return destFile.toString();
		
	}
}
