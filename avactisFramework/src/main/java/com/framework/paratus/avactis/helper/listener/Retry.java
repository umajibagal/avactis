package com.framework.paratus.avactis.helper.listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;

public class Retry implements IRetryAnalyzer {

	private Logger logger = LoggerHelper.getLogger(Retry.class);
	private int retryCount = 0;
	private int maxRetryCount = 3;

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			logger.info("retrying test : " + result.getName() + " with status "
					+ getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " times");
			retryCount++;
			return true;
		}

		return false;
	}

	public String getResultStatusName(int status) {

		String resultName = null;

		if (status == 1) {
			resultName = "SUCCESS";
		} else if (status == 2) {
			resultName = "FAILURE";
		} else if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}
}
