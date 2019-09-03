package com.framework.paratus.avactis.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManagerHelper {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent == null)
			return createIntance("test-output/avactis extent.html");
		else
			return extent;
	}
	
	public static ExtentReports createIntance(String file) {
		
		ExtentHtmlReporter htmlReporter = new  ExtentHtmlReporter(file);
		
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(file);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Avactis Report");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		 return extent;
	}
}
