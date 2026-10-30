package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private MyAccountPage myAccountPage;

	@BeforeMethod(description = "Logging in with valid credentails")
	public void loginWithValidCredentails() {

		myAccountPage = homePage.goToLoginPage().doLoginWith("pikace9130@fun4k.com", "Test@1234");
	}

	@Test(description = "Validate if correct search result is shown", groups = { "e2e", "sanity" })
	public void SearchProductValidationTest() {

	boolean actualNames = myAccountPage.searchProduct(SEARCH_TERM).getProductNameList(SEARCH_TERM);

	Assert.assertTrue(actualNames);	
	
	}

}
