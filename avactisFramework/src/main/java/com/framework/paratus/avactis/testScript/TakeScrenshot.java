package com.framework.paratus.avactis.testScript;

import org.testng.annotations.Test;

import com.framework.paratus.avactis.testbase.TestBase;

public class TakeScrenshot extends  TestBase{

	@Test
	public void testScreen() {
		driver.get("https://www.soapui.org/");
		captureScreenshot("demo");
	}
}
