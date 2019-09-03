package com.framework.paratus.avactis.testScript;

import org.testng.annotations.Test;

import com.framework.paratus.avactis.helper.assertion.AssertionHelper;
import com.framework.paratus.avactis.testbase.TestBase;

public class Test2 extends TestBase {

	@Test
	public void test1() {
		AssertionHelper.makeTrue();
	}
	@Test
	public void test2() {
		AssertionHelper.makeFalse();
	}
	@Test
	public void test3() {
		AssertionHelper.makeTrue();
	}
	@Test
	public void test4() {
		AssertionHelper.makeFalse();
	}
}
