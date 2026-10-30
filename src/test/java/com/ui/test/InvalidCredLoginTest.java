package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredLoginTest extends TestBase {

	@Test(description = "Validating if Error message is received while trying to login with invalid credentials"
			, groups = {"e2e", "regression", "smoke"})
	public void LoginWithInValidCredentials() {

		String actualErrorMessage = homePage.goToLoginPage().doLoginWithInvalidCredentails("xyz@gmail.com", "tst123");

		Assert.assertEquals(actualErrorMessage, "Authentication failed.");

	}

}
