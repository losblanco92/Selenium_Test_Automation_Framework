package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public final class LoginTest extends TestBase {

  Logger logger	= LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verifies if valid user is able to login", groups = { "e2e",
			"sanity" }, retryAnalyzer = com.ui.listeners.MyRetryUtil.class)
	public void loginTest() {

		
		assertEquals(homePage.goToLoginPage().doLoginWith("pikace9130@fun4k.com", "Test@1234").getUserName(),
				"Neeraj Joshi");
	}

}
