package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.ProductPage;

@Listeners(com.ui.listeners.TestListener.class)
public class ProductCheckOutTest extends TestBase {

	
	private static final String SEARCH_TERM = "Printed Dress";

	ProductPage productPage;

	@BeforeMethod(description = "User Logs in to the website and searches for a product")
	public void loginWithValidCredentails() {
		productPage = homePage.goToLoginPage().doLoginWith("pikace9130@fun4k.com", "Test@1234")
				.searchProduct(SEARCH_TERM);

	}

	@Test(description = "Verify if logged in user is able to make a purchase", groups = { "e2e", "santiny" })
	public void checkoutTest() {
		
		
		String actualAlert = productPage.addProductAt(0).addToCart("M").checkOut();

		Assert.assertEquals(actualAlert, "No payment modules have been installed.");

	}

}
