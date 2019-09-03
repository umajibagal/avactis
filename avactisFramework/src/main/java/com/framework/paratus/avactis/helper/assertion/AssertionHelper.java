package com.framework.paratus.avactis.helper.assertion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;

public class AssertionHelper {
	private static Logger logger = LoggerHelper.getLogger(AssertionHelper.class);
	
	public static void verifyText(String actual,String expected) {
		logger.info("verifying text  : "+actual+" with "+expected); 
		assertEquals(actual, expected);
	}
	
	public static void makeTrue() {
		logger.info("making script pass");
		assertTrue(true);
	}
	public static void makeTrue(String message) {
		logger.info("making script pass : "+message);
		assertTrue(true,message);
	}
	
	public static void makeFalse() {
	
		logger.info("making script fail");
		assertFalse(false);
	}
	public static void makeFalse(String message) {
		logger.info("making script fail : "+message);
		assertFalse(false,message);
	}

	public static void verifyTrue(boolean status) {
		assertTrue(status);
	}
	
	public static void verifyFalse(boolean status) {
		assertFalse(status);
	}
	
	public static void verifyNull(String str) {
		logger.info("verify object is null");
		assertNull(str);
	}
	
	public static void verifyNotNull(String str) {
		logger.info("verify object is not null");
		assertNotNull(str);
	}
}
