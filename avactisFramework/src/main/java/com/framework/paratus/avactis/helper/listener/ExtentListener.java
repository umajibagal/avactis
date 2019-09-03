package com.framework.paratus.avactis.helper.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework.paratus.avactis.utils.ExtentReportManagerHelper;

public class ExtentListener implements ITestListener{

	public static ExtentReports extents;
	public static ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		//test.log(Status.INFO, result.getName()+" started ....");
		Reporter.log(result.getMethod().getMethodName()+" Test started ");
	}

	public void onTestSuccess(ITestResult result) {
		//test.log(Status.INFO, result.getName()+" passed ....");	
		Reporter.log(result.getMethod().getMethodName()+" Test passed ");
	}

	public void onTestFailure(ITestResult result) {
		//test.log(Status.FAIL, result.getThrowable());	
		Reporter.log(result.getMethod().getMethodName()+" Test failed "+ result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		//test.log(Status.SKIP, result.getThrowable());	
		Reporter.log(result.getMethod().getMethodName()+" Test skepped "+ result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//extents = ExtentReportManagerHelper.getInstance();
     	//test =extents.createTest(context.getName());
		Reporter.log(context.getName()+" Test started");
	}

	public void onFinish(ITestContext context) {
	//	extents.flush();
		Reporter.log(context.getName()+" Test finished");
	}

}
